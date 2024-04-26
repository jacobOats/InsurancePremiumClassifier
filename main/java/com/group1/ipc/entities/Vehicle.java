package com.group1.ipc.entities;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String vin;
	private String make;
	private String model;
	private int year;
	private int miles;
	private String plate;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="client_id")
	@JsonBackReference
	private Client client;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Payment> payments;
	
	public Vehicle() {
	}

	public Vehicle(int id, String vin, String make, String model, int year, int miles, String plate) {
		super();
		this.id = id;
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.miles = miles;
		this.plate = plate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, make, miles, model, plate, vin, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return id == other.id && Objects.equals(make, other.make) && miles == other.miles
				&& Objects.equals(model, other.model) && Objects.equals(plate, other.plate)
				&& Objects.equals(vin, other.vin) && year == other.year
				&& (client == null && other.client == null || client.getId() == other.client.getId());
	}
	
}
