package com.electricity_company.controllers.models;

import javax.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegistrationModel extends UserRegistrationModel {
    @Min(0)
    private double salary;
}