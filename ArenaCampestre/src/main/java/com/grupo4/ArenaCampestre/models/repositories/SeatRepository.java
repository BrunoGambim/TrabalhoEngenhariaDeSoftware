package com.grupo4.ArenaCampestre.models.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Seat;
import com.grupo4.ArenaCampestre.models.enums.SeatState;
import com.grupo4.ArenaCampestre.models.enums.Sector;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	public List<Seat> findBySectorAndStateNot(Sector sector, SeatState state);
	public List<Seat> findBySectorAndState(Sector sector, SeatState state);
	public List<Seat> findByStateNot(SeatState state);
	public List<Seat> findByState(SeatState state);
	

	@Query(value="select * from seat where id not in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join rent on rent.id = transaction.id where event_id = :id) and state = :#{#state?.getCode()-1}", nativeQuery=true)
	public List<Seat> findByStateAndEvent(@Param("state")SeatState state,Long id);
	
	@Query(value="select * from seat where id not in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join rent on rent.id = transaction.id where event_id = :id) and sector = :#{#sector?.getCode()-1} and state = :#{#state?.getCode()-1}", nativeQuery=true)
	public List<Seat> findBySectorAndStateAndEvent(@Param("sector")Sector sector,@Param("state")SeatState state,Long id);
	
	@Query(value="select * from seat where seat.id not in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join rent on rent.id = transaction.id left join event on event_id = event.id where event.date > :date) and state != :#{#state?.getCode()-1}", nativeQuery=true)
	public List<Seat> findNotRentedOrSoldSeat(@Param("date")Date date, @Param("state")SeatState state);
	
	@Query(value="select * from seat where seat.id in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join buy on transaction.id = buy.id where buy.status = 0 and customer_id = :#{#customer?.getId()})", nativeQuery=true)
	public List<Seat> findByCustomer(@Param("customer")Customer customer);
	
	@Query(value="select * from seat where seat.id in (SELECT distinct seat_id FROM seat right join transaction on seat.id = transaction.id right join buy on transaction.id = buy.id where buy.status = 0 and customer_id = :#{#customer?.getId()}) and sector = :#{#sector?.getCode()-1}", nativeQuery=true)
	public List<Seat> findBySectorAndCustomer(@Param("sector")Sector sector, @Param("customer")Customer customer);
}

