package com.report_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamsController {
    @RequestMapping("/teams")
    public String showTeamsManagement() {
        return "manage-teams";
    }

    @RequestMapping("/team")
    public String showTeam() {
        return "team";
    }

    @RequestMapping("/team/reports")
    public String showTeamReports() {
        return "team-reports";
    }
}
