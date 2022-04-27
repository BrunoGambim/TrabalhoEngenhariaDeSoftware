package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Purchase;
import com.grupo4.ArenaCampestre.models.entities.Rent;
import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.entities.Sale;
import com.grupo4.ArenaCampestre.models.entities.Transaction;

public interface TransactionService {
	public void save(Transaction transaction);
	public Purchase findPurchaseByCustomerAndSeat(Seat seat, Customer customer);
	public List<Purchase> findByCreatedAtGreaterThanEqual(Date date);
	public List<Purchase> findAllPurchases();
	public List<Sale> findSaleByCustomerAndDateGreaterThan(Date date, Customer customer);	
	public List<Sale> findSaleByCustomer(Customer customer);
	public List<Purchase> findPurchaseByCustomerAndDateGreaterThan(Date date, Customer customer);	
	public List<Purchase> findPurchaseByCustomer(Customer customer);
	public List<Rent> findRentByCustomerAndDateGreaterThan(Date date, Customer customer);	
	public List<Rent> findRentByCustomer(Customer customer);
}