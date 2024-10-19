package ru.gb.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.model.dto.EquipmentDto;
import ru.gb.maintenance.model.dto.PostDto;
import ru.gb.maintenance.service.EmployeeService;
import ru.gb.maintenance.service.EquipmentService;
import ru.gb.maintenance.service.PostServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostControllerImpl extends BaseEntityControllerImpl<Post, PostDto> {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EquipmentService equipmentService;

    public PostControllerImpl(PostServiceImpl service) {
        super(service);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<EmployeeDto>> findEmployeesByPostId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByPostId(id));
    }

    @GetMapping("/{id}/equipments")
    public ResponseEntity<List<EquipmentDto>> findEmployeesByCategoryId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findByCategoryId(id));
    }

}
