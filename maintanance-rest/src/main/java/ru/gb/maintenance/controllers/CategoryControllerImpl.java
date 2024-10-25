package ru.gb.maintenance.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.dtos.CategoryDto;
import ru.gb.maintenance.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryControllerImpl extends BaseEntityControllerImpl<Category, CategoryDto>{

//    @Autowired
//    EquipmentService equipmentService;

    public CategoryControllerImpl(CategoryService service) {
        super(service);
    }

//    @GetMapping("/{id}/departments")
//    public ResponseEntity<List<EquipmentDto>> findEquipmentsByCategoryId(@PathVariable Long id) {
//
//        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByCategoryId(id));
//    }
}
