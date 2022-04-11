package com.grupo4.ArenaCampestre.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo4.ArenaCampestre.models.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
}
