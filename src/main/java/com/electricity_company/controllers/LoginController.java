package com.electricity_company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String showLogin(Model model) {
        String title = "Login page";
        model.addAttribute("title", title);

        return "login";
    }
}
