package ru.gb.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Category;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.dto.CategoryDto;
import ru.gb.maintenance.model.dto.CompanyDto;
import ru.gb.maintenance.model.dto.DepartmentDto;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.service.CategoryService;
import ru.gb.maintenance.service.CompanyServiceImpl;
import ru.gb.maintenance.service.DepartmentService;
import ru.gb.maintenance.service.EquipmentService;

import java.util.List;

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
