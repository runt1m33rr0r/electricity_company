package com.electricity_company.services.contracts;

import java.util.Collection;

import com.electricity_company.entities.User;
import com.electricity_company.services.models.UserServiceModel;
import com.electricity_company.exceptions.InvalidDataException;

public interface IRegistrationService {
    User registerUser(UserServiceModel user, Collection<String> roles) throws InvalidDataException;
}