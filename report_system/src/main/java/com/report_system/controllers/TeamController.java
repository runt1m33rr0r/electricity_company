package com.report_system.controllers;

import javax.validation.Valid;

import com.report_system.entities.Team;
import com.report_system.services.contracts.ITeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController {
    @Autowired
    private ITeamService teamService;

    @GetMapping("/teams")
    public String showTeamsManagement(Team team) {
        return "manage-teams";
    }

    @PostMapping("/teams")
    public String createTeam(@Valid Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "manage-teams";
        }

        this.teamService.saveTeam(team);

        return "manage-teams";
    }

    @GetMapping("/team")
    public String showTeam() {
        return "team";
    }

    @GetMapping("/team/reports")
    public String showTeamReports() {
        return "team-reports";
    }
}