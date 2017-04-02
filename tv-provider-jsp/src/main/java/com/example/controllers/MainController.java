package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.ClientService;

@Controller
public class MainController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/")
	public String index() {
		return "index";
	}		
	
	
}
