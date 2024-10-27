package ru.gb.maintenance.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Equipment;
import ru.gb.maintenance.model.Maintenance;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.model.maps.MaintenanceMapper;
import ru.gb.maintenance.repositories.EquipmentRepository;
import ru.gb.maintenance.repositories.MaintenanceRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl extends BaseEntityServiceImpl<Maintenance, MaintenanceDto, MaintenanceMapper> implements MaintenanceService {
    private final MaintenanceRepository repository;

    @Autowired
    EquipmentRepository equipmentRepository;

//    @Autowired
//    MalfunctionService malfunctionService;
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, MaintenanceMapper mapper, MaintenanceRepository repository) {
        super(maintenanceRepository, mapper);
        this.repository = maintenanceRepository;
    }

    public Optional<MaintenanceDto> findById(Long id) {
        return Optional.of(mapper.toDto(repository.findById(id).orElseThrow()));
    }


    @Override
    @Transactional
    public MaintenanceDto save(MaintenanceDto dto) {

        Maintenance maintenance = repository.save(mapper.toEntity(dto));
        Equipment equipment = maintenance.getEquipment();
        Long equipmentId = equipment.getId();
        LocalDate equipmentDate = equipment.getMaintenanceDate();
        LocalDate date = maintenance.getDate();

        if(equipmentDate==null || date.isAfter(equipmentDate)) {
//            equipmentRepository.setMaintenanceDate(equipmentId, date);
            equipment.setMaintenanceDate(date);
            equipmentRepository.save(equipment);
        }
        return mapper.toDto(maintenance);

    }

//    private void updateMaintenanceDate(Long id, Long equipment_id, LocalDate date, LocalDate maintenance_date) {
//        if (maintenance_date == null || date.isAfter(maintenance_date))
//            equipmentRepository.setMaintenanceDate(equipment_id, date);
//        else
//            equipmentRepository.setMaintenanceDate(equipment_id);
//
//    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        Maintenance maintenance = repository.findById(id).orElseThrow();
        Equipment equipment = maintenance.getEquipment();

        boolean isLastMaintenance = equipment.getMaintenanceDate() != null
                        && maintenance.getDate().equals(equipment.getMaintenanceDate());


        super.deleteById(id);
        if (isLastMaintenance) {
            // В equipment j ТО, обновляем дату в таблице equipment
            equipment.setMaintenanceDate(repository.getLastDateMaintenance(equipment.getId()).orElse(null));
            equipmentRepository.save(equipment);
        }
    }

    @Override
    @Transactional
    public MaintenanceDto updateById(MaintenanceDto dto, Long id) throws NoSuchElementException {
        Maintenance oldMaintenance = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MaintenanceID [" + id + "] is missing!"));

        dto.setId(id);

        Equipment oldEquipment = oldMaintenance.getEquipment();
        if (!dto.getEquipmentId().equals(oldEquipment.getId())
                || !dto.getDate().equals(oldMaintenance.getDate())) {
            LocalDate date = repository.getOtherLastDateMaintenance(oldEquipment.getId(), id).orElse(null);
            oldEquipment.setMaintenanceDate(date);
            equipmentRepository.save(oldEquipment);
        }
        return save(dto);

    }
}
