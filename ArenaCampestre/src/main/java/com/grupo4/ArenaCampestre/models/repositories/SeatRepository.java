package com.grupo4.ArenaCampestre.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.ArenaCampestre.models.entities.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
}
