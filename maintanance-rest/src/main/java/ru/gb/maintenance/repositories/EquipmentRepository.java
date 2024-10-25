package ru.gb.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.maintenance.model.Equipment;

import java.util.List;

public interface EquipmentRepository extends BaseEntityRepository<Equipment>, JpaSpecificationExecutor<Equipment> {
    List<Equipment> findByCategoryId(Long id);

    List<Equipment> findByEmployeeId(Long id);

    List<Equipment> findByDepartmentId(Long id);

    List<Equipment> findByModelId(Long id);

    @Query("SELECT e FROM Equipment e INNER JOIN e.department d WHERE d.company.id = :id")
        // join Department e where e.Department.Company.id = ?1")
    List<Equipment> findByCompanyId(@Param("id") Long id);

    @Query("select e from Equipment e INNER JOIN e.model m WHERE m.manufacturer.id = :id ")
        // e where e.model.manufacturer.id = ?1")
    List<Equipment> findByManufacturerId(@Param("id") Long id);

}
