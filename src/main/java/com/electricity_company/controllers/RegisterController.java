package com.electricity_company.controllers;

import javax.validation.Valid;
import com.electricity_company.controllers.models.UserRegistrationModel;
import com.electricity_company.services.contracts.IRegistrationService;
import com.electricity_company.services.models.UserServiceModel;
import com.exceptions.InvalidDataException;
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
    private final ModelMapper mapper;
    private final IRegistrationService registrationService;

    @GetMapping("/clients/register")
    public String showClientRegister(@ModelAttribute("user") UserRegistrationModel user) {
        return "register-client";
    }

    @GetMapping("/employees/register")
    public String showEmployeeRegister(@ModelAttribute("user") UserRegistrationModel user) {
        return "register-employee";
    }

    @PostMapping("/clients")
    public String registerClient(Model model, @Valid @ModelAttribute("user") UserRegistrationModel user,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register-client";
        }

        UserServiceModel serviceModel = this.mapper.map(user, UserServiceModel.class);
        try {
            this.registrationService.registerUser(serviceModel);
        } catch (InvalidDataException e) {
            model.addAttribute("error", e.getMessage());

            return "register-client";
        }

        model.addAttribute("success", "Registration successful!");

        return "register-client";
    }
}
