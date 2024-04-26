package com.group1.ipc.proxies;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.group1.ipc.dtos.QuoteDTO;

@Component
public class MLProxy {
	
	private final HttpClient client = HttpClient.newHttpClient();

	public String getTypes() throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
										 .GET()
										 .uri(new URI("http://localhost:8000/vType"))
										 .build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}
	
	public String getMakes() throws IOException, InterruptedException, URISyntaxException {
		HttpRequest request = HttpRequest.newBuilder()
										 .GET()
										 .uri(new URI("http://localhost:8000/vMake"))
										 .build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}
	
	public String getUsages() throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
										 .GET()
										 .uri(new URI("http://localhost:8000/vUsage"))
										 .build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}
	
	public  String getQuote(QuoteDTO quoteDTO) throws IOException, InterruptedException, URISyntaxException {
		Gson gson = new Gson();
		String body = gson.toJson(quoteDTO);
		HttpRequest request = HttpRequest.newBuilder()
										 .uri(new URI("http://localhost:8000/ml"))
										 .POST(BodyPublishers.ofString(body))
										 .build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}
	
}
