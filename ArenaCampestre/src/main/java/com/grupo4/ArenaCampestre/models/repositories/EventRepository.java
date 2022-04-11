package com.grupo4.ArenaCampestre.models.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo4.ArenaCampestre.models.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	Event findByDate(Date date);
	
	@Query(value="SELECT distinct event.* FROM event left join rent on event.id = rent.event_id or event_id = null left join transaction on rent.id = transaction.id where ifnull(seat_id,999999) != :seatId and event.date > :date", nativeQuery=true)
	List<Event> findByRent(Long seatId, Date date);
}

