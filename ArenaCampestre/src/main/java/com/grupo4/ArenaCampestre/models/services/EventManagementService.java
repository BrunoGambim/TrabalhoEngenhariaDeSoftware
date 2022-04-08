package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;

import com.grupo4.ArenaCampestre.models.entities.Event;

public interface EventManagementService {
	void addEvent(Event event);
	Event findByDate(Date date);
}
