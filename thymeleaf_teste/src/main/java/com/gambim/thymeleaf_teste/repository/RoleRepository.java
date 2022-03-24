package com.gambim.thymeleaf_teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gambim.thymeleaf_teste.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
