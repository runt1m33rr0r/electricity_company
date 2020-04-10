package com.electricity_company.services.contracts;

import com.electricity_company.services.models.UserServiceModel;
import com.exceptions.InvalidDataException;

public interface IRegistrationService {
    void registerUser(UserServiceModel user) throws InvalidDataException;
}