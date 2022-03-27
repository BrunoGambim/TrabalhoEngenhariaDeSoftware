package com.grupo4.ArenaCampestre.models.services;

import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

public interface SeatService {
	List<Seat> findByStateNot(SeatState state);
	List<Seat> findBySectorAndStateNot(Sector sector, SeatState state);
}
