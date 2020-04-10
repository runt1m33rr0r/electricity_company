package com.electricity_company.services;

import java.util.Set;
import javax.transaction.Transactional;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import com.electricity_company.entities.User;
import com.electricity_company.repositories.UsersRepository;
import com.electricity_company.services.contracts.IRegistrationService;
import com.electricity_company.services.models.UserServiceModel;
import com.exceptions.InvalidDataException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RegistrationService implements IRegistrationService {
    private final ModelMapper mapper;
    private final UsersRepository usersRepository;
    private final Validator validator;

    @Override
    public void registerUser(UserServiceModel user) throws InvalidDataException {
        if (user == null) {
            throw new InvalidDataException("No user data provided!");
        }

        if (this.usersRepository.existsByEmail(user.getEmail())) {
            throw new InvalidDataException("User already exists!");
        }

        User userEntity = this.mapper.map(user, User.class);
        Set<ConstraintViolation<User>> violations = this.validator.validate(userEntity);
        if (violations.size() > 0) {
            throw new InvalidDataException("User data is invalid!");
        }

        this.usersRepository.save(userEntity);
    }
}