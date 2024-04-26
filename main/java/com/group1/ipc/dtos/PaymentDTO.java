package com.group1.ipc.dtos;

import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentDTO {
	
    private int id;
    private BigDecimal amount;
    private LocalDate dueDate;
    private Client client;
    private boolean missed;
    private VehicleDTO vehicle;
    
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

    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isMissed() {
        return missed;
    }

    public void setMissed(boolean missed) {
        this.missed = missed;
    }

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

}
