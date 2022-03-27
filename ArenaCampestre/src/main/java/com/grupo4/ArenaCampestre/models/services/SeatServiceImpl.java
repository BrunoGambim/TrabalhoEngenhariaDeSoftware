package com.grupo4.ArenaCampestre.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;
import com.grupo4.ArenaCampestre.models.repositories.SeatRepository;


@Service
public class SeatServiceImpl implements SeatService{
	
	@Autowired
	SeatRepository seatRepository;
	
	@Override
	public List<Seat> findByStateNot(SeatState state) {
		return seatRepository.findByStateNot(state);
	}
	
	@Override
	public List<Seat> findBySectorAndStateNot(Sector sector, SeatState state) {
		return seatRepository.findBySectorAndStateNot(sector, state);
	}
}
