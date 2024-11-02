package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "contractor")
public class Contractor extends BaseEntity {
//    @Column(name = "employee_id")
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;
}
