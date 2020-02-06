package com.report_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping("/clients/register")
    public String showClientRegister() {
        return "register-client";
    }

    @RequestMapping("/employees/register")
    public String showEmployeeRegister() {
        return "register-employee";
    }
}
