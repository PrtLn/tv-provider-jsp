package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Client;
import com.example.service.ClientService;

@RestController
public class HomeRestController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/home")
	public String home() {
		return "TV Provider Java Web Application";
	}

	@GetMapping("/all-clients")
	public String allClients() {
		return clientService.findAll().toString();
	}
	
	@GetMapping("/save-client")
	public String saveClient(@RequestParam String name, @RequestParam String email) {
		Client client = new Client(name, email);
		clientService.save(client);
		return "Client added to database";
	}
	
	@GetMapping("/delete-client")
	public String deleteClient(@RequestParam int id) {
		clientService.delete(id);
		return "Client deleted from database";
	}
	
}
