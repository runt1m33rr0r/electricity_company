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
public class Prices extends BaseEntity {
    @Min(0)
    private double privateIndividualPrice;

    @Min(0)
    private double legalEntityPrice;
}