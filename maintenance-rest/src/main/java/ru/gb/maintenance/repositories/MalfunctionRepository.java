package ru.gb.maintenance.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Malfunction;

import java.util.List;

@Repository
public interface MalfunctionRepository extends BaseEntityRepository<Malfunction> {  //, JpaSpecificationExecutor<Malfunction> {
    List<Malfunction> findByMaintenanceId(Long id);
    void deleteByMaintenanceId(Long id);
}
