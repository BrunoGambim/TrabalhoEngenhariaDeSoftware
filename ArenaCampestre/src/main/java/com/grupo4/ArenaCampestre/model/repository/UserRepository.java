package com.grupo4.ArenaCampestre.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.ArenaCampestre.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
