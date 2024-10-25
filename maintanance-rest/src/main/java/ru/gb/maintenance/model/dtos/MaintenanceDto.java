package ru.gb.maintenance.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class MaintenanceDto extends BaseDto{

    private LocalDate date;

//    @JsonProperty("category")
//    private String categoryName;
//
//    @JsonProperty("model_id")
//    private Long modelId;
//
//    @JsonProperty("department_id")
//    private Long departmentId;

    @JsonProperty("contractor_id")
    private Long contractorId;


//    @JsonProperty("serial_number")
//    private String serialNumber;
//
//    @JsonProperty("inventory_number")
//    private String inventoryNumber;
//
//
//    @JsonProperty("service_number")
//    private String serviceNumber;
//
//    @JsonProperty("start_usage_date")
//    private LocalDate startUsageDate;
//
//    @JsonProperty("maintenance_date")
//    private LocalDate maintenanceDate;
}
