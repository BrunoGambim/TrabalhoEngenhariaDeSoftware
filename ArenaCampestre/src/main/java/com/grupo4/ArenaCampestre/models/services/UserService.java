package com.grupo4.ArenaCampestre.models.services;

import com.grupo4.ArenaCampestre.models.entities.User;

public interface UserService {
	void save(User user);
    User findByUsername(String username);
    public User getLoggedUser();
}
