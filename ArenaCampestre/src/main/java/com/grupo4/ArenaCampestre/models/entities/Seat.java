package com.grupo4.ArenaCampestre.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Sector sector;
	private SeatState state;
	private String code;
	
	private static double PRICE = 50;
	
	public Seat() {
	}

	public Seat(Sector sector, SeatState state, String code) {
		super();
		this.sector = sector;
		this.state = state;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public SeatState getState() {
		return state;
	}

	public void setState(SeatState state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}
	
	public Double getPrice() {
		return PRICE;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
