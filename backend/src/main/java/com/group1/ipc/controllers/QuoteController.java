package com.group1.ipc.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group1.ipc.dtos.QuoteDTO;
import com.group1.ipc.proxies.MLProxy;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {
	
	private final MLProxy proxy;
	
	public QuoteController(MLProxy proxy) {
		this.proxy = proxy;
	}
	
	@GetMapping("/types")
	public String types() throws URISyntaxException, IOException, InterruptedException {
		return proxy.getTypes();
	}
	
	@GetMapping("/makes")
	public String makes() throws IOException, InterruptedException, URISyntaxException {
		return proxy.getMakes();
	}
	
	@GetMapping("/usages")
	public String usages() throws URISyntaxException, IOException, InterruptedException {
		return proxy.getUsages();
	}
	
	@PostMapping
	public String quote(@RequestBody QuoteDTO quoteDTO) throws IOException, InterruptedException, URISyntaxException {
		return proxy.getQuote(quoteDTO);
	}
}
