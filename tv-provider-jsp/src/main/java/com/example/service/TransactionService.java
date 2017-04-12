package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TransactionRepository;
import com.example.models.Transaction;

@Service
public class TransactionService {

	@Autowired
	private final TransactionRepository transactionRepository;
	
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	public List<Transaction> findAll() {
		List<Transaction> transactions = new ArrayList<>();
		for(Transaction transaction : transactionRepository.findAll()) {
			transactions.add(transaction);
		}
		return transactions;
	}
	
	public void save(Transaction transaction) {
		System.out.println("FROM SAVE METHOD");
		this.transactionRepository.save(transaction);		
	}

	public Transaction findTransaction(int id) {
		return transactionRepository.findOne(id);
	}
}
