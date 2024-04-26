package com.group1.ipc.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate claimDate;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	public Claim() {
	}

	public Claim(int id, LocalDate claimDate) {
		super();
		this.id = id;
		this.claimDate = claimDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(claimDate, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Claim other = (Claim) obj;
		return Objects.equals(claimDate, other.claimDate) && id == other.id
			   && (client == null && other.client == null || client.getId() == other.client.getId())
			   && (vehicle == null && other.vehicle == null || vehicle.getId() == other.vehicle.getId());
	}
	
	
	
}
