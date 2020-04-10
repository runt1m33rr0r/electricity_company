package com.electricity_company.services.contracts;

import com.electricity_company.services.models.UserServiceModel;
import com.electricity_company.exceptions.InvalidDataException;

public interface IClientsService {
    void createClient(UserServiceModel user) throws InvalidDataException;
}