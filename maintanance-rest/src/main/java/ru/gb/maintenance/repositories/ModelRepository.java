package ru.gb.maintenance.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Model;

import java.util.List;

@Repository
public interface ModelRepository extends BaseEntityRepository<Model> {
    List<Model> findByManufacturerId(Long id);
}
