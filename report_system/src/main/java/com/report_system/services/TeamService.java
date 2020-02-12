package com.report_system.services;

import com.report_system.entities.Team;
import com.report_system.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void saveTeam(Team team) {
        this.teamRepository.save(team);
    }
}