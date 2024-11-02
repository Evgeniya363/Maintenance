package ru.gb.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.gb.maintenance.model.Maintenance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MaintenanceRepository extends BaseEntityRepository<Maintenance>, JpaSpecificationExecutor<Maintenance> {
    //    List<Equipment> findByCategoryId(Long id);

//    List<Maintenance> findByEmployeeId(Long id);

    List<Maintenance> findByContractorId(Long id);

    List<Maintenance> findByEquipmentIdOrderByDateDesc(Long id);

    @Query(value = "select max(date) from maintenance where equipment_id = ?1", nativeQuery = true)
    Optional<LocalDate> getLastDateMaintenance(Long equipmentId);

    //1 and id <> ?2
    @Query(value = "select max(date) from maintenance where equipment_id = ?1 and id <> ?2", nativeQuery = true)
    Optional<LocalDate> getOtherLastDateMaintenance(Long equipmentId, Long id);


//    List<Equipment> findByDepartmentId(Long id);

//    List<Equipment> findByModelId(Long id);

//    @Query("SELECT e FROM Equipment e INNER JOIN e.department d WHERE d.company.id = :id")
//        // join Department e where e.Department.Company.id = ?1")
//    List<Equipment> findByCompanyId(@Param("id") Long id);
//
//    @Query("select e from Equipment e INNER JOIN e.model m WHERE m.manufacturer.id = :id ")
//        // e where e.model.manufacturer.id = ?1")
//    List<Equipment> findByManufacturerId(@Param("id") Long id);

}
