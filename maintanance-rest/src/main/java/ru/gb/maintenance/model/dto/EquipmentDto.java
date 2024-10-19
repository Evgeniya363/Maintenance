package ru.gb.maintenance.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class EquipmentDto extends BaseDto{

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("category_name")
    private String categoryName;


    @JsonProperty("department_id")
    private Long departmentId;

    @JsonProperty("department_name")
    private String departmentName;

    @JsonProperty("employee_id")
    private Long employeeId;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("serial_number")
    private String serialNumber;

    @JsonProperty("inventory_number")
    private String inventoryNumber;

    @JsonProperty("start_usage_date")
    private LocalDate startUsageDate;

    @JsonProperty("maintenance_date")
    private LocalDate maintenanceDate;
}
