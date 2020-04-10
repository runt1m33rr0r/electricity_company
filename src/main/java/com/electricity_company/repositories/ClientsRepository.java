package com.electricity_company.repositories;

import com.electricity_company.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Long> {
    boolean existsByUserEmail(String email);

    Client findByUserEmail(String email);
}