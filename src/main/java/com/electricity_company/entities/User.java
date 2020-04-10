package com.electricity_company.entities;

import java.util.List;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "is_deleted='false'")
public class User extends BaseEntity {
    @Column(nullable = false)
    @Length(min = 3, max = 30)
    @NotEmpty
    private String firstName;

    @Column(nullable = false)
    @Length(min = 3, max = 30)
    @NotEmpty
    private String lastName;

    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 30)
    @NotEmpty
    private String email;

    @Column(nullable = false)
    @Length(min = 3)
    @NotEmpty
    private String password;

    @ManyToMany
    private List<UserRole> roles;
}