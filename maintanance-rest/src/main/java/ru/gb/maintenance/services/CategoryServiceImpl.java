package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dtos.CategoryDto;
import ru.gb.maintenance.model.maps.CategoryMapper;
import ru.gb.maintenance.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl extends BaseEntityServiceImpl<Category, CategoryDto, CategoryMapper> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }
}
