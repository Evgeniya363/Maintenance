package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee extends BaseEntity {
//    @Id
//    @EqualsAndHashCode.Include
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;

    @Column(name = "first_name")
    private String name;

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
    @Column(name = "full_name")
    private String abbreviatedName() {
        return getInitial(name) + getInitial(patronymic) + secondName;
    }

    @Transient
    private String getInitial(String name) {
        return name.isEmpty() ? "" : name.charAt(0) + ". ";
    }
}
