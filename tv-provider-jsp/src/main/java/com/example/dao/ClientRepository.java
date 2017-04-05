package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
}
