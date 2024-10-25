package ru.gb.maintenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dtos.EmployeeDto;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.model.dtos.PostDto;
import ru.gb.maintenance.services.EmployeeService;
import ru.gb.maintenance.services.MaintenanceServiceImpl;
import ru.gb.maintenance.services.PostServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceControllerImpl extends BaseEntityControllerImpl<Maintenance, MaintenanceDto> {

//    @Autowired
//    EmployeeService employeeService;

    public MaintenanceControllerImpl(MaintenanceServiceImpl service) {
        super(service);
    }

//    @GetMapping("/{id}/employees")
//    public ResponseEntity<List<EmployeeDto>> findEmployeesByPostId(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByPostId(id));
//    }


}
