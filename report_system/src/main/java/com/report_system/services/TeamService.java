package com.report_system.services;

import com.report_system.entities.Team;
import com.report_system.repositories.TeamRepository;
import com.report_system.services.contracts.ITeamService;

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
}