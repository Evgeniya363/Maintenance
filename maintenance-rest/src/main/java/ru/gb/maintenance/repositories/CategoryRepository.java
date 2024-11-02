package ru.gb.maintenance.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Category;

@Repository
public interface CategoryRepository extends BaseEntityRepository<Category> {
}
