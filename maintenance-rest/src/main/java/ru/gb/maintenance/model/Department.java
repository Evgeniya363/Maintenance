package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "department")
public class Department extends SimpleEntity {

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

}
