package com.electricity_company.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController {

    @GetMapping("/teams")
    public String showTeamsManagement(Model model) {
        return "manage-teams";
    }

    @PostMapping("/teams")
    public String createTeam(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "manage-teams";
        }

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
