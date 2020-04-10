package com.electricity_company.services.models;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceModel {
    @Length(min = 3, max = 30)
    @NotEmpty
    private String firstName;

    @Length(min = 3, max = 30)
    @NotEmpty
    private String lastName;

    @Length(min = 3, max = 30)
    @NotEmpty
    private String email;

    @Length(min = 3, max = 30)
    @NotEmpty
    private String password;
}