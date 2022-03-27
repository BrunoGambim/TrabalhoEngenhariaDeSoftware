package com.grupo4.ArenaCampestre.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	List<Seat> findBySectorAndStateNot(Sector sector, SeatState state);
	List<Seat> findByStateNot(SeatState state);
}
