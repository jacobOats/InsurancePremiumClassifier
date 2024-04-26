package com.group1.ipc.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.group1.ipc.entities.Employee;

public interface IEmployeeRepository extends ListCrudRepository<Employee, Integer> {

	Optional<Employee> findByEmail(String email);
	
}
