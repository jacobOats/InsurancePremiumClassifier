package com.group1.ipc.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.ClientDTO;
import com.group1.ipc.entities.Client;

public interface IClientService {
	
	List<ClientDTO> getAllClients();
	void addClient(ClientDTO clientDTO);
	Optional<Client> getClient(int id);
	void updateClient(int id, ClientDTO clientDTO);
	void deleteClient(int id);

	ClientDTO returnClientInfo(Client client);
	
	void changePassword(int id, String password);
	
}
