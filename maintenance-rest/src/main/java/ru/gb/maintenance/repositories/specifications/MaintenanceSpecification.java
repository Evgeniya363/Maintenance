package ru.gb.maintenance.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.repositories.criteria.MaintenanceCriteria;

import java.time.LocalDate;

@Component
public class MaintenanceSpecification {

    public Specification<Maintenance> build(MaintenanceCriteria params) {
        return withCategoryId(params.getCategoryId())
                .and(withDepartmentId(params.getDepartmentId()))
                .and(withCompanyId(params.getCompanyId()))
                .and(withEmployeeId(params.getEmployeeId()))
                .and(withContractorId(params.getContractorId()))
                .and(withModelId(params.getModelId()))
                .and(withManufacturerId(params.getManufacturerId()))
                .and(withContractorId(params.getContractorId()))
                .and(withEquipmentId(params.getEquipmentId()))
                .and(isDateGreaterThan(params.getBeginDate()))
                .and(isDateLessThan(params.getEndDate()))
                ;
    }

    private Specification<Maintenance> withDepartmentId(Long departmentId) {
        return (root, query, criteriaBuilder) -> departmentId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("department").get("id"), departmentId);
    }

    private Specification<Maintenance> withCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) -> categoryId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("category").get("id"), categoryId);
    }

    private Specification<Maintenance> withEmployeeId(Long employeeId) {
        return (root, query, criteriaBuilder) -> employeeId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("employee").get("id"), employeeId);
    }

    private Specification<Maintenance> withModelId(Long modelId) {
        return (root, query, criteriaBuilder) -> modelId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("model").get("id"), modelId);
    }

    private Specification<Maintenance> withCompanyId(Long companyId) {
        return (root, query, criteriaBuilder) -> companyId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("department").get("company").get("id"), companyId);
    }

    private Specification<Maintenance> withManufacturerId(Long manufacturerId) {
        return (root, query, criteriaBuilder) -> manufacturerId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("model").get("manufacturer").get("id"), manufacturerId);
    }
    private Specification<Maintenance> withContractorId(Long contractorId) {
        return (root, query, criteriaBuilder) -> contractorId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("contractor").get("id"), contractorId);
    }

    private Specification<Maintenance> withEquipmentId(Long equipmentId) {
        return (root, query, criteriaBuilder) -> equipmentId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("equipment").get("id"), equipmentId);
    }

    private Specification<Maintenance> isDateLessThan(LocalDate date) {
        return (root, query, criteriaBuilder) -> date == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("date"), date);
    }

    private Specification<Maintenance> isDateGreaterThan(LocalDate date) {
        return (root, query, criteriaBuilder) -> date == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("date"), date);
    }

}