package com.electricity_company.controllers;

import javax.validation.Valid;

import com.electricity_company.controllers.models.EmployeeRegistrationModel;
import com.electricity_company.controllers.models.UserRegistrationModel;
import com.electricity_company.services.contracts.IClientsService;
import com.electricity_company.services.contracts.IEmployeesService;
import com.electricity_company.services.models.EmployeeServiceModel;
import com.electricity_company.services.models.UserServiceModel;
import com.electricity_company.exceptions.InvalidDataException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RegisterController {
    private final IClientsService clientsService;
    private final IEmployeesService employeesService;
    private final ModelMapper mapper;

    @GetMapping("/clients/register")
    public String showClientRegister(@ModelAttribute("user") UserRegistrationModel user) {
        return "register-client";
    }

    @GetMapping("/employees/register")
    public String showEmployeeRegister(@ModelAttribute("user") EmployeeRegistrationModel user) {
        return "register-employee";
    }

    @PostMapping("/clients/register")
    public String registerClient(Model model, @Valid @ModelAttribute("user") UserRegistrationModel user,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register-client";
        }

        UserServiceModel serviceModel = this.mapper.map(user, UserServiceModel.class);
        try {
            this.clientsService.createClient(serviceModel);
        } catch (InvalidDataException e) {
            model.addAttribute("error", e.getMessage());

            return "register-client";
        }

        model.addAttribute("success", "Successfully registered!");

        return "register-client";
    }

    @PostMapping("/employees/register")
    public String registerEmployee(Model model, @Valid @ModelAttribute("user") EmployeeRegistrationModel user,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register-employee";
        }

        EmployeeServiceModel serviceModel = this.mapper.map(user, EmployeeServiceModel.class);
        try {
            this.employeesService.createEmployee(serviceModel);
        } catch (InvalidDataException e) {
            model.addAttribute("error", e.getMessage());

            return "register-employee";
        }

        model.addAttribute("success", "Successfully registered!");

        return "register-employee";
    }
}
