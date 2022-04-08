package com.grupo4.ArenaCampestre.models.services;

import java.sql.Date;

public interface EventManagementService {
	public void AddEvent(String name, String description, Date date);
}
