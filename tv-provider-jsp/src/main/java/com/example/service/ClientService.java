package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.dao.ClientRepository;
import com.example.models.Client;

@Service
@Transactional
public class ClientService {
	
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		for(Client client : clientRepository.findAll()) {
			clients.add(client);
		}
		return clients;
	}


}
