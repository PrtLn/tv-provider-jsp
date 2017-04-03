package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {}
