package com.grupo4.ArenaCampestre.models.entities;

import java.sql.Date;

import javax.persistence.Entity;

import com.grupo4.ArenaCampestre.models.enums.PurchaseStatus;

@Entity
public class Purchase extends Transaction{
	private PurchaseStatus status;
	
	public Purchase() {}
	
	public Purchase(Seat seat, Customer customer, Double price, Date createdAt, PurchaseStatus status) {
		super(seat, customer, price, createdAt);
		this.status = status;
	}
	
	public PurchaseStatus getStatus() {
		return status;
	}
	
	public void setStatus(PurchaseStatus status) {
		this.status = status;
	}
}
