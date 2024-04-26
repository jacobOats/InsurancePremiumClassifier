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
import com.group1.ipc.entities.Vehicle;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.repositories.IVehicleRepository;

@ActiveProfiles("test")
@SpringBootTest
public class VehicleRepositoryTests {

	@Autowired
	IVehicleRepository vehicleRepository;
	
	@Autowired
	IClientRepository clientRepository;
	
	
	@AfterEach
	public void cleanup() {
		vehicleRepository.deleteAll();
		clientRepository.deleteAll();
	}
	
	@Test
	public void save_success() {
		// Arrange
		Client client = new Client();
		Vehicle vehicle = new Vehicle(0, "vin", "make", "model", 2002, 100, "plate");
		vehicle.setClient(client);
		
		// Act
		vehicleRepository.save(vehicle);
		
		// Assert
		Optional<Vehicle> savedVehicle = vehicleRepository.findById(vehicle.getId());
		assertTrue(savedVehicle.isPresent());
		assertEquals(vehicle, savedVehicle.get());
	}
}
