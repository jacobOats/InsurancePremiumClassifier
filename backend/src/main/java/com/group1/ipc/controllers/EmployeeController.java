package com.group1.ipc.controllers;

import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.AddEmployeeDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group1.ipc.entities.Employee;
import com.group1.ipc.services.interfaces.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final IEmployeeService employeeService;
	
	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/emp")
	public List<Employee> getAllEmps() {
		return employeeService.getAllEmps();
	}
	
	@GetMapping("/emp/{id}")
	public Optional<Employee> getEmp(@PathVariable int id) {
		return employeeService.getEmp(id);
	}
	
	@PostMapping("/emp")
	public void addEmp(@RequestBody AddEmployeeDTO addEmpDTO) {
		employeeService.addEmp(addEmpDTO);
	}

	@PutMapping("/emp/{id}")
	public void updateEmp(@RequestBody AddEmployeeDTO addEmpDTO, @PathVariable int id) {
		employeeService.updateEmp(id, addEmpDTO);
	}
	
	@DeleteMapping("/emp/{id}")
	public void deleteEmp(@PathVariable int id) {
		employeeService.deleteEmp(id);
	}
}
