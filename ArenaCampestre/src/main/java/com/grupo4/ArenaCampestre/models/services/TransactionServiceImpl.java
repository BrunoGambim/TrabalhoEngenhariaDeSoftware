package com.grupo4.ArenaCampestre.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Transaction;
import com.grupo4.ArenaCampestre.models.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
}
