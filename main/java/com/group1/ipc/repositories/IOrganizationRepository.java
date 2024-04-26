package com.group1.ipc.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.group1.ipc.entities.Organization;

public interface IOrganizationRepository extends ListCrudRepository<Organization, Integer> {

}
