package com.electricity_company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
    @RequestMapping("/clients")
    public String showClientsManagement() {
        return "manage-clients";
    }
}
