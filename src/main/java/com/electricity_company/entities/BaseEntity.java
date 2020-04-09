package com.electricity_company.entities;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}