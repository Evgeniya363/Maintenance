package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    private String patronymic;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    @Transient
//    @Column(name = "full_name")
//    private String abbreviatedName() {
//        return getInitial(name) + getInitial(patronymic) + secondName;
//    }
//
//    @Transient
//    private String getInitial(String name) {
//        return name.isEmpty() ? "" : name.charAt(0) + ". ";
//    }

}
