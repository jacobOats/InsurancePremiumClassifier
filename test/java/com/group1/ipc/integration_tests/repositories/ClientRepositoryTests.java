package com.group1.ipc.integration_tests.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Employee;
import com.group1.ipc.entities.Organization;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.repositories.IEmployeeRepository;

@ActiveProfiles("test")
@SpringBootTest
public class ClientRepositoryTests {

	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@AfterEach
	public void cleanup() {
		clientRepository.deleteAll();
		employeeRepository.deleteAll();
	}
	
	@Test
	public void save_success() {
		// Arrange
		Organization organization = new Organization(0, "name", "address");
		Employee employee = new Employee(0, "first", "last", null, organization);
		Client client = new Client(0, "address", "first", "last");
		
		// Act
		clientRepository.save(client);
		
		// Assert
		Optional<Client> savedClient = clientRepository.findById(client.getId());
		assertTrue(savedClient.isPresent());
		assertEquals(client, savedClient.get());
	}
}
