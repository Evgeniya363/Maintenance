package ru.gb.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "equipment")
public class Equipment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @Column(name = "start_usage_date")
    private LocalDate startUsageDate;

    @Column(name = "maintenance_date")
    private LocalDate maintenanceDate;

}
