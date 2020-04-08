package com.electricity_company.repositories;

import com.electricity_company.entities.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}