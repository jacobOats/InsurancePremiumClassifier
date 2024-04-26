package com.group1.ipc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.AddEmployeeDTO;
import com.group1.ipc.dtos.EmployeeDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.group1.ipc.entities.Employee;
import com.group1.ipc.repositories.IEmployeeRepository;
import com.group1.ipc.services.interfaces.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	private final IEmployeeRepository employeeRepository;
	private PasswordEncoder passwordEncoder;
	public EmployeeService(IEmployeeRepository employeeRepository,PasswordEncoder passwordEncoder) {
		this.employeeRepository = employeeRepository;
		this.passwordEncoder =passwordEncoder;
	}
	
	public List<Employee> getAllEmps(){
		List<Employee> emps = new ArrayList<>();
		employeeRepository.findAll().forEach(emps :: add);
		return emps;
	}
	
	public Optional<Employee> getEmp(int id) {
		return employeeRepository.findById(id);
	}
	
	public void addEmp(AddEmployeeDTO addEmpDTO) {
		Employee emp=new Employee();
		emp.setFirstName(addEmpDTO.getFirstName());
		emp.setLastName(addEmpDTO.getLastName());
		emp.setEmail(addEmpDTO.getEmail());
		emp.setPassword(passwordEncoder.encode(addEmpDTO.getPassword()));;
		emp.setManager(addEmpDTO.getManager());
		emp.setOrganization(addEmpDTO.getOrganization());
		employeeRepository.save(emp);
	}



	public void updateEmp(int id, AddEmployeeDTO addEmpDTO) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee emp = optionalEmployee.get();
			emp.setFirstName(addEmpDTO.getFirstName());
			emp.setLastName(addEmpDTO.getLastName());
			emp.setManager(addEmpDTO.getManager());
			employeeRepository.save(emp);
		} else {
			throw new EntityNotFoundException("Employee with ID " + id + " not found");
		}
	}

	
	public void deleteEmp(int id) {
		employeeRepository.deleteById(id);
	}


}
