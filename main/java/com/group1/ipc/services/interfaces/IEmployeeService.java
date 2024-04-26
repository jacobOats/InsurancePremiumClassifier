package com.group1.ipc.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.AddEmployeeDTO;
import com.group1.ipc.entities.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmps();

	Optional<Employee> getEmp(int id);

	void addEmp(AddEmployeeDTO addEmployeeDTO);

	void updateEmp(int id, AddEmployeeDTO addEmployeeDTO);

	void deleteEmp(int id);

}
