package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.repositories.criteria.MaintenanceCriteria;

import java.util.List;

public interface MaintenanceService extends BaseEntityService<Maintenance, MaintenanceDto> {
    List<Maintenance> findByCriteria(MaintenanceCriteria params);
}
