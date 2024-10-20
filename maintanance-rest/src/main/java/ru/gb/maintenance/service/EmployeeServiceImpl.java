package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Employee;
import ru.gb.maintenance.model.dto.EmployeeDto;
import ru.gb.maintenance.model.map.EmployeeMapper;
import ru.gb.maintenance.repositiry.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseEntityServiceImpl<Employee, EmployeeDto, EmployeeMapper> implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

    @GetMapping
    @Override
    public List<EmployeeDto> findByPostId(Long id) {
        return mapper.toDtoS(repository.findByPostId(id));
    }

    @Override
    public List<EmployeeDto> findByDepartmentId(Long id) {
        return null;
    }


}

