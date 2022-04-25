package com.grupo4.ArenaCampestre.models.services;

import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

public interface SeatService {
	public List<Seat> findByStateNot(SeatState state);
	public List<Seat> findBySectorAndStateNot(Sector sector, SeatState state);
	public void setSeatsForSale(List<Seat> seats);
	public Seat findById(Long id);
}
