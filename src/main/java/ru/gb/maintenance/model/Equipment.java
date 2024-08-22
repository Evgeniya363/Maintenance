package ru.gb.maintenance.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Equipment {
//    private Serviceable equipment;
    Department department;
    String serialNumber;
    String inventoryNumber;
//    Jobable responsibleEmployee;
    LocalDate startUsageDate;
    LocalDate maintenanceDate;
//    Jobable maintenanceEmployee;
}
