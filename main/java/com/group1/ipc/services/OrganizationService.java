package com.group1.ipc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.group1.ipc.dtos.OrganizationDTO;
import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.group1.ipc.entities.Organization;
import com.group1.ipc.repositories.IOrganizationRepository;
import com.group1.ipc.services.interfaces.IOrganizationService;

@Service
public class OrganizationService implements IOrganizationService {

	private IOrganizationRepository organizationRepository;
	
	public OrganizationService(IOrganizationRepository organizationRepository) {
		this.organizationRepository = organizationRepository;
	}
	
	public List<Organization> getAllOrgs(){
		List<Organization> orgs = new ArrayList<>();
		organizationRepository.findAll().forEach(orgs :: add);
		return orgs;
	}
	
	public Optional<Organization> getOrg(int id) {
		return organizationRepository.findById(id);
	}
	
	public void addOrg(OrganizationDTO orgDTO) {
		Organization org=new Organization();
		org.setName(orgDTO.getName());
		org.setAddress(orgDTO.getAddress());
		organizationRepository.save(org);
	}

	public void updateOrg(int id, OrganizationDTO orgDTO) {
		Optional<Organization> optionalOrganization = organizationRepository.findById(id);
		if (optionalOrganization.isPresent()) {
			Organization org = optionalOrganization.get();
			org.setName(orgDTO.getName());
			org.setAddress(orgDTO.getAddress());
			organizationRepository.save(org);
		} else {
			throw new EntityNotFoundException("Organization with ID " + id + " not found");
		}

	}
	
	public void deleteOrg(int id) {
		organizationRepository.deleteById(id);
	}
}
