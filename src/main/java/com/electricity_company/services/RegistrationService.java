package com.electricity_company.services;

import java.util.*;
import javax.transaction.Transactional;
import com.electricity_company.entities.User;
import com.electricity_company.entities.UserRole;
import com.electricity_company.repositories.RolesRepository;
import com.electricity_company.repositories.UsersRepository;
import com.electricity_company.services.contracts.IRegistrationService;
import com.electricity_company.services.contracts.IValidationService;
import com.electricity_company.services.models.UserServiceModel;
import com.electricity_company.exceptions.InvalidDataException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RegistrationService implements IRegistrationService {
    private final ModelMapper mapper;
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final IValidationService validator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserServiceModel user, Collection<String> roles) throws InvalidDataException {
        if (user == null) {
            throw new InvalidDataException("No user data provided!");
        }

        if (roles == null || roles.isEmpty()) {
            throw new InvalidDataException("Invalid user roles!");
        } else {
            for (String role : roles) {
                if (role == null || role == "") {
                    throw new InvalidDataException("Invalid user role!");
                }
            }
        }

        if (this.usersRepository.existsByEmail(user.getEmail())) {
            throw new InvalidDataException("User already exists!");
        }

        this.validator.validate(user);

        User userEntity = this.mapper.map(user, User.class);
        this.validator.validate(userEntity);

        List<UserRole> userRoles = new ArrayList<>();
        for (String role : roles) {
            UserRole currentRole = new UserRole(role);
            this.validator.validate(currentRole);

            if (!this.rolesRepository.existsByName(role)) {
                this.rolesRepository.save(currentRole);
            } else {
                currentRole = this.rolesRepository.findByName(role);
            }

            userRoles.add(currentRole);
        }

        userEntity.setRoles(userRoles);
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
        this.usersRepository.save(userEntity);

        return userEntity;
    }
}