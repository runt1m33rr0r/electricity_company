package com.electricity_company.controllers;

import javax.validation.Valid;

import com.electricity_company.controllers.models.UserRegistrationModel;
import com.electricity_company.services.contracts.IClientsService;
import com.electricity_company.services.contracts.IEmployeesService;
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
    private interface RegisterAction {
        public void execute(UserServiceModel serviceModel) throws InvalidDataException;
    }

    private final IClientsService clientsService;
    private final IEmployeesService employeesService;
    private final ModelMapper mapper;

    private String registerUser(Model model, UserRegistrationModel user, BindingResult bindingResult, String template,
            String successMessage, RegisterAction registerAction) {
        if (bindingResult.hasErrors()) {
            return template;
        }

        UserServiceModel serviceModel = this.mapper.map(user, UserServiceModel.class);
        try {
            registerAction.execute(serviceModel);
        } catch (InvalidDataException e) {
            model.addAttribute("error", e.getMessage());

            return template;
        }

        model.addAttribute("success", successMessage);

        return template;
    }

    @GetMapping("/clients/register")
    public String showClientRegister(@ModelAttribute("user") UserRegistrationModel user) {
        return "register-client";
    }

    @GetMapping("/employees/register")
    public String showEmployeeRegister(@ModelAttribute("user") UserRegistrationModel user) {
        return "register-employee";
    }

    @PostMapping("/clients/register")
    public String registerClient(Model model, @Valid @ModelAttribute("user") UserRegistrationModel user,
            BindingResult bindingResult) {
        return this.registerUser(model, user, bindingResult, "register-client", "Successfully registered!",
                (serviceModel) -> {
                    this.clientsService.createClient(serviceModel);
                });
    }

    @PostMapping("/employees/register")
    public String registerEmployee(Model model, @Valid @ModelAttribute("user") UserRegistrationModel user,
            BindingResult bindingResult) {
        return this.registerUser(model, user, bindingResult, "register-employee", "Successfully registered!",
                (serviceModel) -> {
                    this.employeesService.createEmployee(serviceModel);
                });
    }
}
