package com.electricity_company.services;

import java.util.Arrays;

import com.electricity_company.entities.Employee;
import com.electricity_company.entities.User;
import com.electricity_company.repositories.EmployeesRepository;
import com.electricity_company.services.contracts.IEmployeesService;
import com.electricity_company.services.contracts.IRegistrationService;
import com.electricity_company.services.contracts.IValidationService;
import com.electricity_company.services.models.UserServiceModel;
import com.electricity_company.exceptions.InvalidDataException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeesService implements IEmployeesService {
    private final EmployeesRepository employeesRepository;
    private final IRegistrationService registrationService;
    private final IValidationService validator;

    @Override
    public void createEmployee(UserServiceModel user) throws InvalidDataException {
        if (user == null) {
            throw new InvalidDataException("No user provided!");
        }

        this.validator.validate(user);

        User userEntity = this.registrationService.registerUser(user, Arrays.asList("ROLE_EMPLOYEE"));
        this.employeesRepository.save(new Employee(userEntity, 0));
    }
}