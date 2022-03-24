package com.gambim.thymeleaf_teste.service;

import com.gambim.thymeleaf_teste.model.User;

public interface UserService {
	void save(User user);
    User findByUsername(String username);
}
