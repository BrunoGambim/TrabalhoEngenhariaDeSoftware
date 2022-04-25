package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import com.grupo4.ArenaCampestre.models.entities.Event;

public interface EventService {
	public Event findEventById(Long id);
	public List<Event> findByDateGreaterThan(Date date);
	public void addEvent(Event event);
	public Event findByDate(Date date);
}
