package ru.gb.maintenance.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.repositories.criteria.EquipmentCriteria;

import java.time.LocalDate;

@Component
public class EquipmentSpecification {

    public Specification<Equipment> build(EquipmentCriteria params) {
        return withCategoryId(params.getCategoryId())
                .and(withDepartmentId(params.getDepartmentId()))
                .and(withCompanyId(params.getCompanyId()))
                .and(withEmployeeId(params.getEmployeeId()))
                .and(withModelId(params.getModelId()))
                .and(withManufacturerId(params.getManufacturerId()))
                .and(isDateGreaterThan(params.getBeginDate()))
                .and(isDateLessThan(params.getEndDate()))
                ;
    }

    private Specification<Equipment> withDepartmentId(Long departmentId) {
        return (root, query, criteriaBuilder) -> departmentId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("department").get("id"), departmentId);
    }

    private Specification<Equipment> withCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) -> categoryId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Equipment> withEmployeeId(Long employeeId) {
        return (root, query, criteriaBuilder) -> employeeId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("employee").get("id"), employeeId);
    }

    private Specification<Equipment> withModelId(Long modelId) {
        return (root, query, criteriaBuilder) -> modelId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("model").get("id"), modelId);
    }

    private Specification<Equipment> withCompanyId(Long companyId) {
        return (root, query, criteriaBuilder) -> companyId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("department").get("company").get("id"), companyId);
    }

    private Specification<Equipment> withManufacturerId(Long manufacturerId) {
        return (root, query, criteriaBuilder) -> manufacturerId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("model").get("manufacturer").get("id"), manufacturerId);
    }

    private Specification<Equipment> isDateLessThan(LocalDate date) {
        return (root, query, criteriaBuilder) -> date == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("maintenanceDate"), date);
    }

    private Specification<Equipment> isDateGreaterThan(LocalDate date) {
        return (root, query, criteriaBuilder) -> date == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("maintenanceDate"), date);
    }

//    public static Specification<Equipment> isDepartment(Long departmentId) {
//        return new Specification<Equipment>() {
//            public Predicate toPredicate(
//                    Root<Equipment> root, CriteriaQuery<?> query,
//                    CriteriaBuilder builder) {
//                return builder.equal(root.get("department_id"), departmentId);
//            }
//        };
//    }
//
//    public static Specification<Equipment> isEmployee(Long employeeId) {
//        return new Specification<Equipment>() {
//            public Predicate toPredicate(
//                    Root<Equipment> root, CriteriaQuery<?> query,
//                    CriteriaBuilder builder) {
//                return builder.equal(root.get("employee_id"), employeeId);
//            }
//        };
//    }
//
//    public static Specification<Equipment> isModel(Long modelId) {
//        return new Specification<Equipment>() {
//            public Predicate toPredicate(
//                    Root<Equipment> root, CriteriaQuery<?> query,
//                    CriteriaBuilder builder) {
//                return builder.equal(root.get("model_id"), modelId);
//            }
//        };
//    }
//    public static Specification<Equipment> isCategory(Long categoryId) {
//        return new Specification<Equipment>() {
//            public Predicate toPredicate(
//                    Root<Equipment> root, CriteriaQuery<?> query,
//                    CriteriaBuilder builder) {
//                return builder.equal(root.get("category_id"), categoryId);
//            }
//        };
    }






/* Example
public class CustomerSpecs {
    public static Specification<Customer> isLongTermCustomer() {
        return new Specification<Customer>() {
            public Predicate toPredicate(
                Root<Customer> root, CriteriaQuery<?> query,
                CriteriaBuilder builder) {
                LocalDate date = new LocalDate().minusYears(2);
                return builder.lessThan(root.get('dateField'), date);
            }
        };
    }

    public static Specification<Customer> hasSalesOfMoreThan(MontaryAmount value) {
        return new Specification<Customer>() {
            public Predicate toPredicate(
                Root<T> root, CriteriaQuery<?> query,
                CriteriaBuilder builder) {
                // build query here
            }
        };
    }
}
 */
