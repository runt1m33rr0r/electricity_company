package com.electricity_company.services;

import java.util.Arrays;

import com.electricity_company.entities.Client;
import com.electricity_company.entities.User;
import com.electricity_company.repositories.ClientsRepository;
import com.electricity_company.services.contracts.IClientsService;
import com.electricity_company.services.contracts.IRegistrationService;
import com.electricity_company.services.contracts.IValidationService;
import com.electricity_company.services.models.UserServiceModel;
import com.electricity_company.exceptions.InvalidDataException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientsService implements IClientsService {
    private final ClientsRepository clientsRepository;
    private final IRegistrationService registrationService;
    private final IValidationService validator;

    @Override
    public void createClient(UserServiceModel user) throws InvalidDataException {
        if (user == null) {
            throw new InvalidDataException("No user provided!");
        }

        this.validator.validate(user);

        User userEntity = this.registrationService.registerUser(user, Arrays.asList("ROLE_CLIENT"));
        this.clientsRepository.save(new Client(userEntity, null));
    }
}