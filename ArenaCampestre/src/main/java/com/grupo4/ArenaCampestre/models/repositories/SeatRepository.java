package com.grupo4.ArenaCampestre.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	List<Seat> findBySectorAndStateNot(Sector sector, SeatState state);
	List<Seat> findByStateNot(SeatState state);
	

	@Query(value="select * from seat where id not in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join rent on rent.id = transaction.id where event_id = :id) and state != :#{#state?.getCode()-1}", nativeQuery=true)
	List<Seat> findByStateNotAndEvent(@Param("state")SeatState state,Long id);
	
	@Query(value="select * from seat where id not in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join rent on rent.id = transaction.id where event_id = :id) and sector = :#{#sector?.getCode()-1} and state != :#{#state?.getCode()-1}", nativeQuery=true)
	List<Seat> findBySectorAndStateAndEvent(@Param("sector")Sector sector,@Param("state")SeatState state,Long id);
}
