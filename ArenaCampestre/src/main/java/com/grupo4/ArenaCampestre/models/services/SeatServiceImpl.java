package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Customer;
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
	public List<Seat> findByState(SeatState state) {
		return seatRepository.findByState(state);
	}
	
	@Override
	public List<Seat> findBySectorAndStateNot(Sector sector, SeatState state) {
		return seatRepository.findBySectorAndStateNot(sector, state);
	}
	
	@Override
	public List<Seat> findBySectorAndState(Sector sector, SeatState state) {
		return seatRepository.findBySectorAndState(sector, state);
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
	public List<Seat> findByStateAndEvent(SeatState state, Long id) {
		return seatRepository.findByStateAndEvent(state,id);
	}

	@Override
	public List<Seat> findBySectorAndStateAndEvent(Sector sector, SeatState state, Long id) {
		return seatRepository.findBySectorAndStateAndEvent(sector, state, id);
	}

	@Override
	public void saveSeat(Seat seat) {
		seatRepository.save(seat);
	}

	@Override
	public List<Seat> findNotRentedOrSoldSeat(Date date, SeatState state) {
		return seatRepository.findNotRentedOrSoldSeat(date, state);
	}

	@Override
	public List<Seat> findByCustomer(Customer customer) {
		return seatRepository.findByCustomer(customer);
	}

	@Override
	public List<Seat> findBySectorAndCustomer(Sector sector, Customer customer) {
		return seatRepository.findBySectorAndCustomer(sector, customer);
	}
}
