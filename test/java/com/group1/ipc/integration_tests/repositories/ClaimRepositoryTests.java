package com.group1.ipc.integration_tests.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.group1.ipc.entities.Claim;
import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Vehicle;
import com.group1.ipc.repositories.IClaimRepository;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.repositories.IVehicleRepository;

@ActiveProfiles("test")
@SpringBootTest
public class ClaimRepositoryTests {

	@Autowired
	IClaimRepository claimRepository;
	
	@Autowired
	IClientRepository clientRepository;
	
	@Autowired
	IVehicleRepository vehicleRepository;
	
	@AfterEach
	public void cleanup() {
		claimRepository.deleteAll();
		vehicleRepository.deleteAll();
		clientRepository.deleteAll();
	}
	
	@Test
	public void save_success() {
		// Arrange
		Client client = new Client();
		Vehicle vehicle = new Vehicle(0, "vin", "make", "model", 2002, 100, "plate");
		vehicle.setClient(client);
		
		Claim claim = new Claim(0, LocalDate.now());
		claim.setClient(client);
		claim.setVehicle(vehicle);
		
		// Act
		claimRepository.save(claim);
		
		// Assert
		Optional<Claim> savedClaim = claimRepository.findById(claim.getId());
		assertTrue(savedClaim.isPresent());
		assertEquals(claim, savedClaim.get());
	}
}
