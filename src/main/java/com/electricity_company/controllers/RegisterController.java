package com.electricity_company.controllers;

import com.electricity_company.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping("/clients/register")
    public String showClientRegister(User user) {
        return "register-client";
    }

    @RequestMapping("/employees/register")
    public String showEmployeeRegister(User user) {
        return "register-employee";
    }
}
