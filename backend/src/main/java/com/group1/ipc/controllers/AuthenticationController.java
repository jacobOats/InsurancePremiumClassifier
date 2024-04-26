package com.group1.ipc.controllers;

import com.group1.ipc.dtos.ClientDTO;
import com.group1.ipc.entities.Client;
import com.group1.ipc.services.ClientService;
import com.group1.ipc.services.interfaces.IClientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group1.ipc.dtos.MessageDTO;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	private final IClientService clientService;

    public AuthenticationController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/logged-in")
	public MessageDTO loggedIn(Authentication authentication) {
		boolean loggedIn = authentication != null;
		return new MessageDTO(String.valueOf(loggedIn));
	}
    
	@GetMapping("/logged-in/info")
	public ClientDTO loggedInInfo(Authentication authentication) {
		Client client = (Client)authentication.getPrincipal();
		ClientDTO clientDTO = clientService.returnClientInfo(client);
		return clientDTO;
	}
	
	@PostMapping("/password")
	public ResponseEntity changePassword(@RequestHeader("password") String password, Authentication authentication) {
		Client client = (Client) authentication.getPrincipal();
		clientService.changePassword(client.getId(), password);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
