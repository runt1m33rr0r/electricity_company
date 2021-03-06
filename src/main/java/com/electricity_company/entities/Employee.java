package com.electricity_company.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import org.hibernate.annotations.Where;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "is_deleted='false'")
public class Employee extends BaseEntity {
    @OneToOne
    private User user;

    @Min(0)
    private double salary;
}