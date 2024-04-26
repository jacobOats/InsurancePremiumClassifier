package com.group1.ipc.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.group1.ipc.entities.Claim;

public interface IClaimRepository extends ListCrudRepository<Claim, Integer> {

}
