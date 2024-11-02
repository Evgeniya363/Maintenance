package ru.gb.maintenance.services;

import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.Malfunction;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.model.dtos.MalfunctionDto;
import ru.gb.maintenance.model.maps.MalfunctionMapper;

import java.util.List;
import java.util.Optional;

public interface MalfunctionService extends BaseEntityService<Malfunction, MalfunctionDto> {
    List<MalfunctionDto> findByMaintenanceId(Long id);

    void deleteByMaintenanceId(Long id);
}
