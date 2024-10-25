package ru.gb.maintenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.Malfunction;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.model.dtos.MalfunctionDto;
import ru.gb.maintenance.model.maps.MaintenanceMapper;
import ru.gb.maintenance.repositories.MaintenanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl extends BaseEntityServiceImpl<Maintenance, MaintenanceDto, MaintenanceMapper> implements MaintenanceService {
    private final MaintenanceRepository repository;

//    @Autowired
//    MalfunctionService malfunctionService;
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, MaintenanceMapper mapper, MaintenanceRepository repository) {
        super(maintenanceRepository, mapper);
        this.repository = maintenanceRepository;
    }

    public Optional<MaintenanceDto> findById(Long id) {
        return Optional.of(mapper.toDto(repository.findById(id).orElseThrow()));
    }
}
