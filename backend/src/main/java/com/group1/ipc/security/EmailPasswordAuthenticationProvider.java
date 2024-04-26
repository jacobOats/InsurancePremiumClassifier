package com.group1.ipc.security;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Employee;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.repositories.IEmployeeRepository;

public class EmailPasswordAuthenticationProvider implements AuthenticationProvider {
	
	private final PasswordEncoder passwordEncoder;
	private final IClientRepository clientRepository;
	private final IEmployeeRepository employeeRepository;
	
	public EmailPasswordAuthenticationProvider(PasswordEncoder passwordEncoder, IClientRepository clientRepository, IEmployeeRepository employeeRepository) {
		this.passwordEncoder = passwordEncoder;
		this.clientRepository = clientRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = (String) authentication.getPrincipal();
		String credentials = (String) authentication.getCredentials();
		String encodedCredentials = passwordEncoder.encode(credentials);
		String password = (String) authentication.getCredentials();
		
		if (email != null) {
			Optional<Client> client = clientRepository.findByEmail(email);
			Optional<Employee> employee = employeeRepository.findByEmail(email);
 			if (client.isPresent() && passwordEncoder.matches(password, client.get().getPassword())) {
				return new UsernamePasswordAuthenticationToken(client.get(), null, List.of(new SimpleGrantedAuthority("ROLE_CLIENT")));
			} else if (employee.isPresent() && passwordEncoder.matches(password, employee.get().getPassword())) {
				return new UsernamePasswordAuthenticationToken(employee.get(), null, List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE")));
			}
		}
		
		throw new BadCredentialsException("Email or password invalid.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
