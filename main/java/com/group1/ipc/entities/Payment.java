package com.group1.ipc.entities;

import java.math.BigDecimal;
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
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private BigDecimal amount;
	private LocalDate dueDate;
	private boolean missed;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	public Payment() {
	}

	public Payment(int id, BigDecimal amount, LocalDate dueDate, boolean missed) {
		super();
		this.id = id;
		this.amount = amount;
		this.dueDate = dueDate;
		this.missed = missed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isMissed() {
		return missed;
	}

	public void setMissed(boolean missed) {
		this.missed = missed;
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
		return Objects.hash(amount, dueDate, id, missed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(dueDate, other.dueDate) && id == other.id
				&& missed == other.missed
				&& (client == null && other.client == null || client.getId() == other.client.getId());
	}
	
}
