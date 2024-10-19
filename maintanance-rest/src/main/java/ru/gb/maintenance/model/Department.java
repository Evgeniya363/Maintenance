package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "department")
public class Department extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

}
