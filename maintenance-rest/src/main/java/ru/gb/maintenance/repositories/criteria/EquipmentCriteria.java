package ru.gb.maintenance.repositories.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EquipmentCriteria implements Requestable {
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
    @JsonProperty("begin_date")
    private LocalDate beginDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
}
