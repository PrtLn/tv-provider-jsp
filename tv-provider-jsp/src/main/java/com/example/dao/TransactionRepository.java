package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	
}
