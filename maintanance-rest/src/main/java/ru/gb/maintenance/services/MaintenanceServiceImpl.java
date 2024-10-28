package ru.gb.maintenance.services;

import jakarta.transaction.Transactional;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.*;
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

        dto.setStatus(Status.SCHEDULED);
        if (dto.getType() == null)
            dto.setType(Type.PLANNED);

        Maintenance entity = mapper.toEntity(dto);
        Maintenance maintenance = repository.save(entity);

        maintenance.getEquipment().setMaintenanceDate(
                dto.getDate() == null ? LocalDate.now() : dto.getDate()
        );
        return mapper.toDto(maintenance);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        Maintenance maintenance = repository.findById(id).orElseThrow();
        Equipment equipment = maintenance.getEquipment();
        Long equipmentId = equipment.getId();

        boolean isLastMaintenance =
                equipment.getMaintenanceDate() != null
                        && maintenance.getDate().equals(equipment.getMaintenanceDate());

        if (isLastMaintenance) {
            // В equipment j ТО, обновляем дату в таблице equipment
            LocalDate date = repository.getOtherLastDateMaintenance(equipmentId, id).orElseThrow();
            equipment.setMaintenanceDate(date);
            equipmentRepository.save(equipment);
        }

        super.deleteById(id);


    }

    @Override
    @Transactional
    public MaintenanceDto updateById(MaintenanceDto dto, Long id) throws NoSuchElementException {

        dto.setId(id);
        Maintenance maintenance = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MaintenanceID [" + id + "] is missing!"));

        Equipment oldEquipment = maintenance.getEquipment();
        if (maintenance.getDate() == null)
            throw new RuntimeException("The date cannot be empty!");

        if (!dto.getEquipmentId().equals(oldEquipment.getId())) {
            LocalDate date = repository.getOtherLastDateMaintenance(oldEquipment.getId(), id).orElse(null);
            oldEquipment.setMaintenanceDate(date);
        } else if (dto.getDate().isAfter(maintenance.getDate())) {
            oldEquipment.setMaintenanceDate(maintenance.getDate());
            equipmentRepository.save(oldEquipment);
        }

        setStatusUpdatedItem(
                maintenance.getStatus() == null ? Status.SCHEDULED : maintenance.getStatus(),
                dto.getStatus() == null ? Status.SCHEDULED : dto.getStatus()
        );

        return super.save(dto);

    }

    private void setStatusUpdatedItem(Status oldStatus, Status newStatus) {
        if (!newStatus.equals(oldStatus)) {
            if (
                    !((newStatus == Status.COMPLETED || newStatus == Status.REJECTED || newStatus == Status.POSTPONED)
                            && oldStatus == Status.INWORKS
                            || newStatus == Status.INWORKS && (oldStatus == Status.SCHEDULED || oldStatus == Status.POSTPONED)
                    )
            ) {
                throw new RuntimeException("It is not possible to change the status of the request from " +
                        oldStatus + " to " + newStatus);
            }
        }
    }
}
