package com.gambim.thymeleaf_teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambim.thymeleaf_teste.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
