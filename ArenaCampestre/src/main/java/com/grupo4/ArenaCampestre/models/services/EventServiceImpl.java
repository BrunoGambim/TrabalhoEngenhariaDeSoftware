package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	@Autowired
	EventRepository eventRepository;

	@Override
	public Event findEventById(Long id) {
		return eventRepository.findById(id).get();
	}

	@Override
	public List<Event> findByDateGreaterThan(Date date) {
		return eventRepository.findByDateGreaterThan(date);
	}
	
	@Override
	public void addEvent(Event event) {
		eventRepository.save(event);
	}
	
	@Override
	public Event findByDate(Date date) {
		return eventRepository.findByDate(date);
	}
	
	
}
