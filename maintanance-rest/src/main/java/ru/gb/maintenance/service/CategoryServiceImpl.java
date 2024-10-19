package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dto.CategoryDto;
import ru.gb.maintenance.model.map.CategoryMapper;
import ru.gb.maintenance.repositiry.CategoryRepository;

@Service
public class CategoryServiceImpl extends BaseEntityServiceImpl<Category, CategoryDto, CategoryMapper> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }
}
