package com.electricity_company.services;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.electricity_company.exceptions.InvalidDataException;
import com.electricity_company.services.contracts.IValidationService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ValidationService implements IValidationService {
    private final Validator validator;

    public <T> void validate(T entity) throws InvalidDataException {
        Set<ConstraintViolation<T>> violations = this.validator.validate(entity);
        if (violations.size() > 0) {
            throw new InvalidDataException(violations.iterator().next().getMessage());
        }
    }
}