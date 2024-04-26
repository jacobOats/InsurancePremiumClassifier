package com.group1.ipc.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group1.ipc.dtos.VehicleDTO;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String address;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	public Employee employee;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	@JsonManagedReference
	public List<Vehicle> vehicles;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	@Transient
	public List<Payment> payments;
	
	public Client() {
	}
	
	public Client(int id, String address, String firstName, String lastName) {
		super();
		this.id = id;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addPayment(Payment pay) {
		this.payments.add(pay);
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, employee, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(address, other.address) 
				&& (employee == null && other.employee == null || employee.getId() == other.employee.getId())
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List getVehicles() {
		return vehicles;
	}

	public void setClient(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
