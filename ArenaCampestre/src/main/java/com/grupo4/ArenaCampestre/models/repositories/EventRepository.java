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
	
	@Query(value="select * from event where id not in (SELECT distinct event_id FROM event left join rent on event.id = rent.event_id left join transaction on rent.id = transaction.id where seat_id = :seatId) and event.date > :date", nativeQuery=true)
	List<Event> findBySeat(Long seatId, Date date);
}

