package ru.gb.maintenance.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dtos.CategoryDto;
import ru.gb.maintenance.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryControllerImpl extends BaseEntityControllerImpl<Category, CategoryDto>{
    public CategoryControllerImpl(CategoryService service) {
        super(service);
    }

}
