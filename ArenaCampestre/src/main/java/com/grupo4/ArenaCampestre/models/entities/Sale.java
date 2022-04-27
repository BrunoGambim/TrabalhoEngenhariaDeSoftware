package com.grupo4.ArenaCampestre.models.entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Sale extends Transaction{
	
	public Sale() {
	}
	
	public Sale(Seat seat, Customer customer, Double price, Date createdAt) {
		super(seat, customer, price, createdAt);
	}
}
