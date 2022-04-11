package com.grupo4.ArenaCampestre.models.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Rent extends Transaction{
	
	@ManyToOne
	private Event event;
	
	Rent(){
	}
	public Rent(Seat seat, Customer customer, Event event, Double price) {
		super(seat, customer, price);
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
