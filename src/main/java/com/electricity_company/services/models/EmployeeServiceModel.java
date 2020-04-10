package com.electricity_company.services.models;

import javax.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeServiceModel extends UserServiceModel {
    @Min(0)
    private double salary;
}