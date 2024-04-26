package com.group1.ipc.integration_tests.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.group1.ipc.entities.Organization;
import com.group1.ipc.repositories.IOrganizationRepository;

@ActiveProfiles("test")
@SpringBootTest
public class OrganizationRepositoryTests {

	@Autowired
	private IOrganizationRepository organizationRepository;
	
	@AfterEach
	public void cleanup() {
		organizationRepository.deleteAll();
	}
	
	@Test
	public void save_success() {
		// Arrange
		Organization organization = new Organization(0, "name", "address");
		
		// Act
		organizationRepository.save(organization);
		
		// Assert
		Optional<Organization> savedOrganization = organizationRepository.findById(organization.getId());
		assertTrue(savedOrganization.isPresent());
		assertEquals(organization, savedOrganization.get());
	}
}
