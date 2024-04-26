package com.group1.ipc.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.group1.ipc.dtos.PaymentDTO;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Payment;
import com.group1.ipc.services.interfaces.IPaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	private final IPaymentService paymentService;
	
	public PaymentController(IPaymentService paymentService) {
		this.paymentService = paymentService;
	}
	@GetMapping
	public List<PaymentDTO> getAllPayments(Authentication authentication) {
		Client client = (Client) authentication.getPrincipal();
		return paymentService.getAllPayments(client.getId());
	}
	
	@GetMapping("/payment/{id}")
	public Optional<Payment> getPayment(@PathVariable int id) {
		return paymentService.getPayment(id);
	}
	
	@PostMapping("/payment")
	public void addPayment(Authentication authentication, @RequestBody PaymentDTO payDTO) {
		Client client = (Client) authentication.getPrincipal();
		paymentService.addPayment(payDTO, client);
	}
	
	@PutMapping("/payment/{id}")
	public void updatePayment(Authentication authentication, @RequestBody PaymentDTO payDTO, @PathVariable int id) {
		Client client = (Client) authentication.getPrincipal();
		paymentService.updatePayment(id, payDTO, client);
	}
	
	@DeleteMapping("/payment/{id}")
	public void deletePayment(@PathVariable int id) {
		paymentService.deletePayment(id);
	}
	
	@GetMapping("/missed")
	public int countAllMissedPayments() {
		return paymentService.countAllMissedPayments();
	}
	
	@GetMapping("/client/missed")
	public List<Client> getAllMissedClients() {
		return paymentService.getAllMissedClients();
	}
	
	@GetMapping("/client/{id}")
	public Stream<Payment> getAllPaymentsByUser(@PathVariable int id){
		return paymentService.getAllPaymentsByUser(id);
	}
}
