package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
