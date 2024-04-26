package com.group1.ipc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.group1.ipc.dtos.PaymentDTO;
import com.group1.ipc.dtos.VehicleDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group1.ipc.entities.Client;
import com.group1.ipc.entities.Payment;
import com.group1.ipc.entities.Vehicle;
import com.group1.ipc.repositories.IClientRepository;
import com.group1.ipc.repositories.IPaymentRepository;
import com.group1.ipc.services.interfaces.IPaymentService;

@Service
public class PaymentService implements IPaymentService {

	private final IPaymentRepository paymentRepository;
	private final IClientRepository clientRepository;
	
	public PaymentService(IPaymentRepository paymentRepository, IClientRepository clientRepository) {
		this.paymentRepository = paymentRepository;
		this.clientRepository = clientRepository;
	}
	
	@Transactional
	public List<PaymentDTO> getAllPayments(int clientId){
		Client client = clientRepository.findById(clientId).get();
		
		List<Payment> payments = client.getPayments();
		if (payments == null) {
			return new ArrayList<>();
		}
		
		return payments.stream()
					   .map(payment -> map(payment, client))
					   .toList();
	}
	
	private PaymentDTO map(Payment payment, Client client) {
		Vehicle vehicle = payment.getVehicle();
		
		VehicleDTO vehicleDTO = new VehicleDTO();
		vehicleDTO.setId(vehicle.getId());
		vehicleDTO.setVin(vehicle.getVin());
		vehicleDTO.setMake(vehicle.getMake());
		vehicleDTO.setModel(vehicle.getModel());
		vehicleDTO.setYear(vehicle.getYear());
		vehicleDTO.setMiles(vehicle.getMiles());
		vehicleDTO.setPlate(vehicle.getPlate());
		
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setId(payment.getId());
		paymentDTO.setAmount(payment.getAmount());
		paymentDTO.setDueDate(payment.getDueDate());
		paymentDTO.setMissed(payment.getDueDate().isAfter(LocalDate.now()));
		paymentDTO.setVehicle(vehicleDTO);
		
		return paymentDTO;
	}
	
	public Optional<Payment> getPayment(int id) {
		return paymentRepository.findById(id);
	}
	
	public void addPayment(PaymentDTO payDTO, Client client) {
		Payment pay=new Payment();
		pay.setAmount(payDTO.getAmount());
		pay.setClient(client);
		pay.setMissed(payDTO.isMissed());
		pay.setDueDate(payDTO.getDueDate());
		paymentRepository.save(pay);
	}

	public void updatePayment(int id, PaymentDTO payDTO, Client client) {
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		if (optionalPayment.isPresent()) {
			Payment pay = optionalPayment.get();
			pay.setAmount(payDTO.getAmount());
			pay.setClient(client);
			pay.setMissed(payDTO.isMissed());
			pay.setDueDate(payDTO.getDueDate());
			paymentRepository.save(pay);
		} else {
			throw new EntityNotFoundException("Payment with ID " + id + " not found");
		}
	}
	
	public void deletePayment(int id) {
		paymentRepository.deleteById(id);
	}
	
	public int countAllMissedPayments() {
		int count = 0;
		List<Payment> payments = new ArrayList<>();
		paymentRepository.findAll().forEach(payments :: add);
		for(int i=0;i<payments.size();i++) {
			if(payments.get(i).isMissed()) {
				count++;
			}
		}
		return count;
	}
	
	public List<Client> getAllMissedClients() {
		List<Payment> payments = new ArrayList<>();
		List<Client> clients = new ArrayList<>();
		paymentRepository.findAll().forEach(payments :: add);
		for(int i=0;i<payments.size();i++) {
			if(payments.get(i).isMissed() && ! clients.contains(payments.get(i).getClient())) {
				clients.add(payments.get(i).getClient());
			}
		}
		return clients;
	}
	
	public Stream<Payment> getAllPaymentsByUser(int id){
		List<Payment> payments = new ArrayList<>();
		paymentRepository.findAll().forEach(payments :: add);
		//filter so only vehicles with client id are left
		return payments.stream().filter(p -> p.getClient().getId() == id);
	}
}
