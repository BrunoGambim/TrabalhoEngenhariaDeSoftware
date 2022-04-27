package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Buy;
import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.entities.Transaction;
import com.grupo4.ArenaCampestre.models.repositories.BuyRepository;
import com.grupo4.ArenaCampestre.models.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	BuyRepository buyRepository;
	
	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public Buy findBuyByCustomerAndSeat(Seat seat, Customer customer) {
		return buyRepository.findByCustomerAndSeat(seat, customer);
	}

	@Override
	public List<Buy> findByCreatedAtGreaterThanEqual(Date date) {
		return buyRepository.findByCreatedAtGreaterThanEqual(date);
	}

	@Override
	public List<Buy> findAllBuys() {
		return buyRepository.findAll();
	}
	
}
