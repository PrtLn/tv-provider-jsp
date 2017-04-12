package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {}
