package ru.gb.maintenance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "equipment")
public class Equipment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @Column(name = "service_number", nullable = false)
    private String serviceNumber;

    @Column(name = "start_usage_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate startUsageDate;

    @Column(name = "maintenance_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate maintenanceDate;

}
