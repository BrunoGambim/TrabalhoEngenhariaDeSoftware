package com.grupo4.ArenaCampestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.ArenaCampestre.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
