package com.report_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamsController {
    @RequestMapping("/teams")
    public String showTeams() {
        return "teams";
    }
}
