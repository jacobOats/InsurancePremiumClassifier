package com.group1.ipc.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.group1.ipc.dtos.OrganizationDTO;
import com.group1.ipc.entities.Organization;

public interface IOrganizationService {

	List<Organization> getAllOrgs();

	Optional<Organization> getOrg(int id);

	void addOrg(OrganizationDTO orgDTO);

	void updateOrg(int id, OrganizationDTO orgDTO);

	void deleteOrg(int id);

}
