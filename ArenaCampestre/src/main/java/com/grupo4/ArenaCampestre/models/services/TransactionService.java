package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Buy;
import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.entities.Transaction;

public interface TransactionService {
	public void save(Transaction transaction);
	public Buy findBuyByCustomerAndSeat(Seat seat, Customer customer);
	public List<Buy> findByCreatedAtGreaterThanEqual(Date date);
	public List<Buy> findAllBuys();
}
