package com.example.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Client;
import com.example.models.Transaction;
import com.example.service.ClientService;
import com.example.service.TransactionService;

@Controller
public class MainController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/")
	public String index(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-clients")
	public String allClients(HttpServletRequest request) {
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "index";
	}
	
	@GetMapping("/new-client")
	public String newClient(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-client")
	public String saveClient(@ModelAttribute Client client, 
				BindingResult bindingResult, HttpServletRequest request) {
		clientService.save(client);
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "index";
	}
	
	@GetMapping("/update-client")
	public String updateClient(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("client", clientService.findClient(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-client")
	public String deleteClient(@RequestParam int id, HttpServletRequest request) {
		clientService.delete(id);
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "index";
	}
	
	
	@GetMapping("/all-transactions")
	public String allTransactions(@ModelAttribute Transaction transaction,
						BindingResult bindingResult, HttpServletRequest request) {
		transaction.setDate(new Date());
		transactionService.save(transaction);
		request.setAttribute("transactions", transactionService.findAll());		
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
}
