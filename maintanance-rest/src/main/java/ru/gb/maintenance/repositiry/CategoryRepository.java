package ru.gb.maintenance.repositiry;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Category;

import java.util.Locale;

@Repository
public interface CategoryRepository extends BaseEntityRepository<Category> {
}
