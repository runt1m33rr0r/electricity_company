package com.electricity_company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserProfileController {
    @RequestMapping("/profile")
    public String showUserProfile() {
        return "profile";
    }
}
