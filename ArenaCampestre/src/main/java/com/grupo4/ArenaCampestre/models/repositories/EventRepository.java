package com.grupo4.ArenaCampestre.models.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo4.ArenaCampestre.models.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	Event findByDate(Date date);
	List<Event> findByDateGreaterThan(Date date);
}

