package com.electricity_company.entities;

import java.util.Date;

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
public class Measurement extends BaseEntity {
    @Min(0)
    private double amount;

    @Min(0)
    private double price;

    @NonNull
    private Date measuredOn;

    @NonNull
    private MeasurementStatus status;

    @ManyToOne
    private Client client;
}