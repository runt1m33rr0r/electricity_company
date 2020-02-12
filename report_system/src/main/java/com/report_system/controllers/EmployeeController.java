package com.report_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @RequestMapping("/employees")
    public String showEmployeesManagement() {
        return "manage-employees";
    }

    @RequestMapping("/employee/reports")
    public String showEmployeeReports() {
        return "employee-reports";
    }

    @RequestMapping("/employee/assigned")
    public String showAssignedEmployeeReports() {
        return "assigned-reports";
    }
}
