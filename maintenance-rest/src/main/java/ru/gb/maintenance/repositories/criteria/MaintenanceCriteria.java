package ru.gb.maintenance.repositories.criteria;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MaintenanceCriteria implements Requestable {

    @JsonProperty("department_id")
    private Long departmentId;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("model_id")
    private Long modelId;

    @JsonProperty("manufacturer_id")
    private Long manufacturerId;

    @JsonProperty("employee_id")
    private Long employeeId;

    @JsonProperty("contractor_id")
    private Long contractorId;

    @JsonProperty("equipment_id")
    private Long equipmentId;

    @JsonProperty("begin_date")
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate beginDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate endDate;
}
