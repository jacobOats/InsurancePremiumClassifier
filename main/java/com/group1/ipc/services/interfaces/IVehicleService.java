package com.group1.ipc.services.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.group1.ipc.dtos.VehicleDTO;
import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Vehicle;

public interface IVehicleService {

	List<VehicleDTO> getAllVehicles();

	Stream<Vehicle> getVehicles(int id);

	void addVehicle(VehicleDTO vDTO,Client client);

	void updateVehicle(int id, VehicleDTO vDTO, Client client);

	void deleteVehicle(int id);

	Optional<Vehicle> getVehicle(int id);

}
