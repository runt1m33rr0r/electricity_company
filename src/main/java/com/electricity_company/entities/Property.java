package com.electricity_company.entities;

import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "is_deleted='false'")
public class Property extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 30)
    @NotEmpty
    private String address;
}