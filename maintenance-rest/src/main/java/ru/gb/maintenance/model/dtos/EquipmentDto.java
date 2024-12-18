package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class EquipmentDto extends BaseDto{

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("model_id")
    private Long modelId;

    @JsonProperty("department_id")
    private Long departmentId;

    @JsonProperty("employee_id")
    private Long employeeId;


    @JsonProperty("serial_number")
    private String serialNumber;

    @JsonProperty("inventory_number")
    private String inventoryNumber;


    @JsonProperty("service_number")
    private String serviceNumber;

    @JsonFormat(pattern="dd.MM.yyyy")
    @JsonProperty("start_usage_date")
    private LocalDate startUsageDate;

    @JsonFormat(pattern="dd.MM.yyyy")
    @JsonProperty("maintenance_date")
    private LocalDate maintenanceDate;
}
