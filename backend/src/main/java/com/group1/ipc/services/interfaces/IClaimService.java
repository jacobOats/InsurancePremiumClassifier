package com.group1.ipc.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.ClaimDTO;
import com.group1.ipc.entities.Claim;
import com.group1.ipc.entities.Client;

public interface IClaimService {

	List<Claim> getAllClaims();

	Optional<Claim> getClaim(int id);

	void addClaim(ClaimDTO c, Client client);

	void updateClaim(int id, ClaimDTO c, Client client);

	void deleteClaim(int id);

	int countClaims();

}
