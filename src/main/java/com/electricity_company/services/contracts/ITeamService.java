package com.electricity_company.services.contracts;

import java.util.Collection;

import com.electricity_company.entities.Team;

public interface ITeamService {
    void saveTeam(Team team);

    Collection<Team> getAll();
}