package com.group1.ipc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.ClientDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.group1.ipc.entities.Client;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.services.interfaces.IClientService;

@Service
public class ClientService implements IClientService {

	private final IClientRepository clientRepository;
	private PasswordEncoder passwordEncoder;
	
	public ClientService(IClientRepository clientRepository,PasswordEncoder passwordEncoder) {
		this.clientRepository = clientRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	public List<ClientDTO> getAllClients(){
		return clientRepository.findAll()
							   .stream()
							   .map(client -> map(client))
							   .toList();
	}
	
	public ClientDTO map(Client client) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(client.getId());
		clientDTO.setAddress(client.getAddress());
		clientDTO.setFirstName(client.getFirstName());
		clientDTO.setLastName(client.getLastName());
		return clientDTO;
	}
	
	public Optional<Client> getClient(int id) {
		return clientRepository.findById(id);
	}

	public void addClient(ClientDTO clientDTO) {
		Client client=new Client();
		client.setFirstName(clientDTO.getFirstName());
		client.setLastName(clientDTO.getLastName());
		client.setAddress(clientDTO.getAddress());
		client.setEmail(clientDTO.getEmail());
		client.setDob(clientDTO.getDob());
		client.setPassword(passwordEncoder.encode(clientDTO.getPassword()));;
		clientRepository.save(client);
	}
	
	@Transactional
	public ClientDTO returnClientInfo(Client client){
		Client freshClient = clientRepository.findById(client.getId()).get();
		
		ClientDTO clientDTO =new ClientDTO();
		clientDTO.setFirstName(freshClient.getFirstName());
		clientDTO.setLastName(freshClient.getLastName());
		clientDTO.setAddress(freshClient.getAddress());
		clientDTO.setEmail(freshClient.getEmail());
		clientDTO.setDob(freshClient.getDob());
		clientDTO.setVehicles(freshClient.getVehicles());
		
		return clientDTO;
	}

	public void updateClient(int id, ClientDTO clientDTO) {
		Optional<Client> optionalClient = clientRepository.findById(id);;
		if (optionalClient.isPresent()) {
			Client client=new Client();
			client.setFirstName(clientDTO.getFirstName());
			client.setLastName(clientDTO.getLastName());
			client.setAddress(clientDTO.getAddress());
			client.setEmployee(clientDTO.getEmployee());
			client.setDob(clientDTO.getDob());
			clientRepository.save(client);
		} else {
			throw new EntityNotFoundException("Employee with ID " + id + " not found");
		}
	}
	
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
	
	public void changePassword(int id, String password) {
		String encodedPassword = passwordEncoder.encode(password);
		clientRepository.updatePassword(id, encodedPassword);
	}
	
}
