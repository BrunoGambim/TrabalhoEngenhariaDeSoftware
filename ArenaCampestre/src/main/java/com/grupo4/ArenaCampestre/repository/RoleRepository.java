package com.grupo4.ArenaCampestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo4.ArenaCampestre.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
