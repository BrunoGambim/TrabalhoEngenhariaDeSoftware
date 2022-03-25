package com.grupo4.ArenaCampestre.service;

import com.grupo4.ArenaCampestre.model.User;

public interface UserService {
	void save(User user);
    User findByUsername(String username);
}
