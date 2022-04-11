package com.grupo4.ArenaCampestre.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@ManyToOne
	private Seat seat;
	@ManyToOne
	private Customer customer;
	
	private Double price;
	
	public Transaction() {
	}
	
	public Transaction(Seat seat, Customer customer, Double price) {
		super();
		this.seat = seat;
		this.customer = customer;
		this.price = price;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
