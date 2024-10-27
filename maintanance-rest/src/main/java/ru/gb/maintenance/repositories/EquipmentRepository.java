package ru.gb.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.maintenance.model.Equipment;

import java.time.LocalDate;
import java.util.List;

public interface EquipmentRepository extends BaseEntityRepository<Equipment>, JpaSpecificationExecutor<Equipment> {
    List<Equipment> findByCategoryId(Long id);

    List<Equipment> findByEmployeeId(Long id);

    List<Equipment> findByDepartmentId(Long id);

    List<Equipment> findByModelId(Long id);

    @Query("select e from Equipment e inner join e.department d where d.company.id = :id")
        // join Department e where e.Department.Company.id = ?1")
    List<Equipment> findByCompanyId(@Param("id") Long id);

    @Query("select e from Equipment e inner join e.model m where m.manufacturer.id = :id ")
        // e where e.model.manufacturer.id = ?1")
    List<Equipment> findByManufacturerId(@Param("id") Long id);

//    @Modifying
//    @Query(value =
//            "update equipment " +
//                    "set maintenance_date = " +
//                    "(select max(m.date) " +
//                    "from maintenance m " +
//                    "where m.equipment_id = ?1) " +
//                    "where id = ?1",
//            nativeQuery = true
//    )
//    void setMaintenanceDate(Long id);
//
//    @Modifying
//    @Query(value =
//            "update equipment " +
//                    "set maintenance_date = ?2" +
//                    "where id = ?1",
//            nativeQuery = true
//    )
//    void setMaintenanceDate(Long id, LocalDate date);
//
//    @Modifying
//    @Query(value =
//            "update equipment " +
//                    "set maintenance_date = " +
//                    "(select max(m.date) " +
//                    "from maintenance m " +
//                    "where m.equipment_id = ?1 and m.id != ?2) " +
//                    "where id = ?1",
//            nativeQuery = true
//    )
//    void setMaintenanceDate(Long id, Long maintenanceId);
}
