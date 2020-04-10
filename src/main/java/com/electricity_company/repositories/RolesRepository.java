package com.electricity_company.repositories;

import com.electricity_company.entities.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<UserRole, Long> {
    boolean existsByName(String name);

    UserRole findByName(String name);
}