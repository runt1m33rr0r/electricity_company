package com.electricity_company.services.contracts;

import com.electricity_company.exceptions.InvalidDataException;

public interface IValidationService {
    <T> void validate(T entity) throws InvalidDataException;
}