package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "patronymic")
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    private String fullName() {
//        return firstName + " " + patronymic + " " + secondName;
//    }

    @Transient
    @Column(name = "abbreviated_name")
    private String abbreviatedName() {
        return getInitial(firstName) + getInitial(patronymic) + secondName;
    }

    private String getInitial(String name) {
        return name.isEmpty() ? "" : name.charAt(0) + ". ";
    }
}
