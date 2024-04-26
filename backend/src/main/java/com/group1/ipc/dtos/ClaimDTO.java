package com.group1.ipc.dtos;

import com.group1.ipc.entities.Claim;
import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Vehicle;

import java.time.LocalDate;

public class ClaimDTO {
    private int id;
    private LocalDate claimDate;

    private Client client;

    private Vehicle vehicle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    /*

    public static ClaimDTO buildFromEntity(Claim claim) {
        ClaimDTO dto = new ClaimDTO();
        dto.setId(claim.getId());
        dto.setClaimDate(claim.getClaimDate());
        //dto.setClient(ClientDTO.buildFromEntity(claim.getClient()));
        //dto.setVehicle(VehicleDTO.buildFromEntity(claim.getVehicle()));
        // Set other fields...
        return dto;
    }

    public Claim buildEntity() {
        Claim claim = new Claim();
        claim.setId(this.id);
        claim.setClaimDate(this.claimDate);
        //claim.setClient(this.client.buildEntity());
        //claim.setVehicle(this.vehicle.buildEntity());
        // Set other fields...
        return claim;
    }

     */
}
