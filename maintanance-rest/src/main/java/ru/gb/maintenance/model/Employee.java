package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    private String name;

    private String patronymic;

    @Column(name = "second_name")
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
