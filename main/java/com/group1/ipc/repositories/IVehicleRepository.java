package com.group1.ipc.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.group1.ipc.entities.Vehicle;

public interface IVehicleRepository extends ListCrudRepository<Vehicle, Integer> {

}
