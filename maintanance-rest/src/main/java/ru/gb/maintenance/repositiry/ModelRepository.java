package ru.gb.maintenance.repositiry;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.Model;
import ru.gb.maintenance.model.dto.ModelDto;

import java.util.List;

@Repository
public interface ModelRepository extends BaseEntityRepository<Model> {
    List<Model> findByManufacturerId(Long id);
}
