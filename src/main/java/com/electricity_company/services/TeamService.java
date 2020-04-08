package com.electricity_company.services;

import java.util.ArrayList;
import java.util.Collection;

import com.electricity_company.entities.Team;
import com.electricity_company.repositories.TeamRepository;
import com.electricity_company.services.contracts.ITeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void saveTeam(Team team) {
        this.teamRepository.save(team);
    }

    @Override
    public Collection<Team> getAll() {
        Collection<Team> teams = new ArrayList<>();
        this.teamRepository.findAll().forEach(team -> teams.add(team));

        return teams;
    }
}