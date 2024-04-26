package com.group1.ipc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.group1.ipc.entities.Client;

import jakarta.transaction.Transactional;

public interface IClientRepository extends ListCrudRepository<Client, Integer> {

	Optional<Client> findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE Client c SET c.password = :password WHERE c.id = :clientId")
	void updatePassword(int clientId, String password);
}
