package ru.gb.maintenance.repositiry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.dto.EquipmentDto;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends BaseEntityRepository<Equipment> {
    List<Equipment> findByCategoryId(Long id);

    List<Equipment> findByEmployeeId(Long id);

    List<Equipment> findByDepartmentId(Long id);

    List<Equipment> findByModelId(Long id);

    @Query("SELECT e FROM Equipment e INNER JOIN e.department d WHERE d.company.id = :id") // join Depar e where e.Department.Company.id = ?1")
    List<Equipment> findByCompanyId(@Param("id") Long id);

    @Query("select e from Equipment e INNER JOIN e.model m WHERE m.manufacturer.id = :id ") // e where e.model.manufacturer.id = ?1")
    List<Equipment> findByManufacturerId(@Param("id") Long id);

//    Example
//@Repository
//public interface OrderRepository extends JpaRepository<Order, Long> {
//    @Query("SELECT o.orderNumber, c.name FROM Order o INNER JOIN o.customer c WHERE o.id = :id")
//    List<Object[]> findOrderDetailsById(@Param("id") Long id);
//}
}
