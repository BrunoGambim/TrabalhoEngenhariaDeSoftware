package com.grupo4.ArenaCampestre.models.entities;

import java.sql.Date;

import javax.persistence.Entity;

import com.grupo4.ArenaCampestre.models.enums.BuyingStatus;

@Entity
public class Buy extends Transaction{
	private BuyingStatus status;
	
	public Buy() {}
	
	public Buy(Seat seat, Customer customer, Double price, Date createdAt, BuyingStatus status) {
		super(seat, customer, price, createdAt);
		this.status = status;
	}
	
	public BuyingStatus getStatus() {
		return status;
	}
	
	public void setStatus(BuyingStatus status) {
		this.status = status;
	}
}
