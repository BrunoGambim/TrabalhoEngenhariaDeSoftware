package com.grupo4.ArenaCampestre.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.ArenaCampestre.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
