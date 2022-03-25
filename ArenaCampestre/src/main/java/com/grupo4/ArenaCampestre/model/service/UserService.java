package com.grupo4.ArenaCampestre.model.service;

import com.grupo4.ArenaCampestre.model.entities.User;

public interface UserService {
	void save(User user);
    User findByUsername(String username);
}
