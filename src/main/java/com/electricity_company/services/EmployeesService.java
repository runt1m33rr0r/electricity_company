package com.electricity_company.services;

import java.util.Arrays;

import com.electricity_company.entities.Employee;
import com.electricity_company.entities.User;
import com.electricity_company.repositories.EmployeesRepository;
import com.electricity_company.services.contracts.IEmployeesService;
import com.electricity_company.services.contracts.IRegistrationService;
import com.electricity_company.services.contracts.IValidationService;
import com.electricity_company.services.models.EmployeeServiceModel;
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
    public void createEmployee(EmployeeServiceModel user) throws InvalidDataException {
        if (user == null) {
            throw new InvalidDataException("No user provided!");
        }

        this.validator.validate(user);

        if (this.employeesRepository.existsByUserEmail(user.getEmail())) {
            throw new InvalidDataException("User already exists!");
        }

        User userEntity = this.registrationService.registerUser(user, Arrays.asList("ROLE_EMPLOYEE"));
        Employee employeeEntity = new Employee(userEntity, user.getSalary());
        this.employeesRepository.save(employeeEntity);
    }
}