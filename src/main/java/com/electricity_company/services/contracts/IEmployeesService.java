package com.electricity_company.services.contracts;

import com.electricity_company.services.models.EmployeeServiceModel;
import com.electricity_company.exceptions.InvalidDataException;

public interface IEmployeesService {
    void createEmployee(EmployeeServiceModel user) throws InvalidDataException;
}