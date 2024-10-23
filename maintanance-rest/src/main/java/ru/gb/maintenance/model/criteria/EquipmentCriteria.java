package ru.gb.maintenance.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentCriteria implements Requestable {
    @JsonProperty("department_id")
    private Long DepartmentId;
    @JsonProperty("category_id")
    private Long CategoryId;
    @JsonProperty("company_id")
    private Long CompanyId;
    @JsonProperty("model_id")
    private Long ModelId;
    @JsonProperty("manufacturer_id")
    private Long ManufacturerId;
    @JsonProperty("employee_id")
    private Long EmployeeId;
}
