package com.group1.ipc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.ClaimDTO;
import com.group1.ipc.entities.Client;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.group1.ipc.entities.Claim;
import com.group1.ipc.repositories.IClaimRepository;
import com.group1.ipc.services.interfaces.IClaimService;

@Service
public class ClaimService implements IClaimService {

	private final IClaimRepository claimRepository;

	public ClaimService(IClaimRepository claimRepository) {
		this.claimRepository = claimRepository;
	}
	
	public List<Claim> getAllClaims(){
		List<Claim> claims = new ArrayList<>();
		claimRepository.findAll().forEach(claims :: add);
		return claims;
	}
	
	public Optional<Claim> getClaim(int id) {

		return claimRepository.findById(id);

	}
	
	public void addClaim(ClaimDTO claimDTO, Client client) {
		Claim claim = new Claim();
		claim.setClaimDate(claimDTO.getClaimDate());
		claim.setClient(client);
		claim.setVehicle(claimDTO.getVehicle());
		claimRepository.save(claim);
	}

	public void updateClaim(int id, ClaimDTO claimDTO, Client client) {

		Optional<Claim> optionalClaim = claimRepository.findById(id);
		if (optionalClaim.isPresent()) {
			Claim claim = new Claim();
			claim.setClaimDate(claimDTO.getClaimDate());
			claim.setClient(client);
			claimRepository.save(claim);
		} else {
			throw new EntityNotFoundException("Claim with ID " + id + " not found");
		}

	}
	
	public void deleteClaim(int id) {
		claimRepository.deleteById(id);
	}
	
	public int countClaims() {
		List<Claim> claims = new ArrayList<>();
		claimRepository.findAll().forEach(claims :: add);
		return claims.size();
	}
}
