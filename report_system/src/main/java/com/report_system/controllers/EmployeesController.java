package com.report_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeesController {
    @RequestMapping("/employees")
    public String showEmployeesManagement() {
        return "manage-employees";
    }
}
