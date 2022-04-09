package com.grupo4.ArenaCampestre.dtos;

import java.util.ArrayList;
import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Seat;

public class SeatsForSaleFormDto {
	private List<Seat> seatList = new ArrayList<>();

	public SeatsForSaleFormDto() {
	}
	
	public SeatsForSaleFormDto(List<Seat> seatList) {
		this.seatList = seatList;
	}

	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}
}
