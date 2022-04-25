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
	
	@Override
	public Seat findById(Long id) {
		return seatRepository.findById(id).get();
	}

	@Override
	public void setSeatsForSale(List<Seat> seats) {
		for(Seat seat: seats) {
			seat.setState(SeatState.AVAILABLE_TO_BUY);
		}
		seatRepository.saveAll(seats);
	}

	@Override
	public List<Seat> findByStateNotAndEvent(SeatState state, Long id) {
		return seatRepository.findByStateNotAndEvent(state,id);
	}

	@Override
	public List<Seat> findBySectorAndStateAndEvent(Sector sector, SeatState state, Long id) {
		return seatRepository.findBySectorAndStateAndEvent(sector, state, id);
	}
}
