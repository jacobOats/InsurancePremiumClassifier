package com.group1.ipc.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	
	@OneToOne
	@JoinColumn(name="manager_id")
	private Employee manager;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	public Employee() {
	}
 	
	public Employee(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(int id, String firstName, String lastName, Employee manager, Organization organization) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.organization = organization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, manager, organization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& ((manager == null && other.manager == null) || manager.getId() == other.manager.getId())
				&& Objects.equals(organization, other.organization);
	}
	
	
	
}
