package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Event;
import com.grupo4.ArenaCampestre.models.repositories.EventRepository;

@Service
public class EventManagementServiceImpl implements EventManagementService{
	
	@Autowired
	EventRepository eventRepository;
	
	@Override
	public void addEvent(Event event) {
		eventRepository.save(event);
	}
	
	@Override
	public Event findByDate(Date date) {
		return eventRepository.findByDate(date);
	}
}
