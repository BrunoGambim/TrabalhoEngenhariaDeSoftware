package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

public interface SeatService {
	public List<Seat> findByStateNot(SeatState state);
	public List<Seat> findByState(SeatState state);
	public List<Seat> findBySectorAndStateNot(Sector sector, SeatState state);
	public List<Seat> findBySectorAndState(Sector sector, SeatState state);
	public void setSeatsForSale(List<Seat> seats);
	public void saveSeat(Seat seat);
	public List<Seat> findByStateAndEvent(SeatState state,Long id);
	public List<Seat> findBySectorAndStateAndEvent(Sector sector,SeatState state,Long id);
	public List<Seat> findNotRentedOrSoldSeat(Date date, SeatState state);
	public Seat findById(Long id);
	public List<Seat> findByCustomer(Customer customer);
	public List<Seat> findBySectorAndCustomer(Sector sector, Customer customer);
}
