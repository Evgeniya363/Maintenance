package ru.gb.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gb.maintenance.model.Malfunction;

public interface MalfunctionRepository extends BaseEntityRepository<Malfunction>, JpaSpecificationExecutor<Malfunction> {


}
