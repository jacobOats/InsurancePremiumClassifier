package com.group1.ipc.integration_tests.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Payment;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.repositories.IPaymentRepository;

@ActiveProfiles("test")
@SpringBootTest
public class PaymentRepositoryTests {

	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	IClientRepository clientRepository;
	
	@AfterEach
	public void cleanup() {
		paymentRepository.deleteAll();
		clientRepository.deleteAll();
	}
	
	@Test
	public void save_success() {
		// Arrange
		Client client = new Client();
		Payment payment = new Payment(0, BigDecimal.valueOf(10.01), LocalDate.now(), false);
		payment.setClient(client);
		
		// Act
		paymentRepository.save(payment);
		
		// Assert
		Optional<Payment> savedPayment = paymentRepository.findById(payment.getId());
		assertTrue(savedPayment.isPresent());
		assertEquals(payment, savedPayment.get());
	}
}
