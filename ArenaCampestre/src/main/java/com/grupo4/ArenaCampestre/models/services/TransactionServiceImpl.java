package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Purchase;
import com.grupo4.ArenaCampestre.models.entities.Rent;
import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.entities.Sale;
import com.grupo4.ArenaCampestre.models.entities.Transaction;
import com.grupo4.ArenaCampestre.models.repositories.PurchaseRepository;
import com.grupo4.ArenaCampestre.models.repositories.RentRepository;
import com.grupo4.ArenaCampestre.models.repositories.SaleRepository;
import com.grupo4.ArenaCampestre.models.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	RentRepository rentRepository;
	
	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public Purchase findPurchaseByCustomerAndSeat(Seat seat, Customer customer) {
		return purchaseRepository.findByCustomerAndSeat(seat, customer);
	}

	@Override
	public List<Purchase> findByCreatedAtGreaterThanEqual(Date date) {
		return purchaseRepository.findByCreatedAtGreaterThanEqual(date);
	}

	@Override
	public List<Purchase> findAllPurchases() {
		return purchaseRepository.findAll();
	}

	@Override
	public List<Sale> findSaleByCustomerAndDateGreaterThan(Date date, Customer customer) {
		return saleRepository.findByCustomerAndDateGreaterThan(date, customer);
	}

	@Override
	public List<Sale> findSaleByCustomer(Customer customer) {
		return saleRepository.findByCustomer(customer);
	}

	@Override
	public List<Purchase> findPurchaseByCustomerAndDateGreaterThan(Date date, Customer customer) {
		return purchaseRepository.findByCustomerAndDateGreaterThan(date, customer);
	}

	@Override
	public List<Purchase> findPurchaseByCustomer(Customer customer) {
		return purchaseRepository.findByCustomer(customer);
	}
	
	@Override
	public List<Rent> findRentByCustomerAndDateGreaterThan(Date date, Customer customer) {
		return rentRepository.findByCustomerAndDateGreaterThan(date, customer);
	}

	@Override
	public List<Rent> findRentByCustomer(Customer customer) {
		return rentRepository.findByCustomer(customer);
	}	
}
