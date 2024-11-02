package ru.gb.maintenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.*;
import ru.gb.maintenance.model.dtos.MaintenanceDto;
import ru.gb.maintenance.model.maps.MaintenanceMapper;
import ru.gb.maintenance.repositories.EquipmentRepository;
import ru.gb.maintenance.repositories.MaintenanceRepository;
import ru.gb.maintenance.repositories.MalfunctionRepository;
import ru.gb.maintenance.repositories.criteria.MaintenanceCriteria;
import ru.gb.maintenance.repositories.specifications.MaintenanceSpecification;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl extends BaseEntityServiceImpl<Maintenance, MaintenanceDto, MaintenanceMapper> implements MaintenanceService {
    private final MaintenanceRepository repository;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    MaintenanceSpecification specification;
    @Autowired
    ContractorService contractorService;
    @Autowired
    MalfunctionRepository malfunctionRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, MaintenanceMapper mapper) {
        super(maintenanceRepository, mapper);
        this.repository = maintenanceRepository;
    }

    public Optional<Maintenance> findById(Long id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }


    @Override
    public MaintenanceDto beforeSave(MaintenanceDto dto) {
        if (dto.getEquipmentId() == null)
            throw new RuntimeException("Equipment is null");

        Equipment equipment = equipmentService
                .findById(dto.getEquipmentId())
                .orElseThrow();

        equipment.setMaintenanceDate(
                dto.getDate() == null ? LocalDate.now() : dto.getDate()
        );

        if (dto.getContractorId() != null) {
            contractorService.findById(dto.getContractorId()).orElseThrow();
        }

        if (dto.getType() == null) dto.setType(Type.PLANNED);
        dto.setStatus(Status.SCHEDULED);

        return dto;
    }

    @Override
    public void beforeDelete(Long id) {
        Maintenance maintenance = repository.findById(id).orElseThrow();
        Equipment equipment = maintenance.getEquipment();
        Long equipmentId = equipment.getId();

        boolean isLastMaintenance =
                equipment.getMaintenanceDate() != null
                        && maintenance.getDate().equals(equipment.getMaintenanceDate());

        if (isLastMaintenance) {
            // В equipment j ТО, обновляем дату в таблице equipment
            LocalDate date = repository.getOtherLastDateMaintenance(equipmentId, id).orElse(null);
            equipment.setMaintenanceDate(date);
            equipmentRepository.save(equipment);
        }

        malfunctionRepository.deleteByMaintenanceId(id);

    }


    @Override
    public MaintenanceDto beforeUpdate(MaintenanceDto dto, Maintenance maintenance) {

        if (dto.getDate() == null)
            throw new RuntimeException("The date cannot be empty!");

        Equipment oldEquipment = maintenance.getEquipment();
        if (oldEquipment != null){
            if (!dto.getEquipmentId().equals(oldEquipment.getId())) {
                LocalDate date = repository.getOtherLastDateMaintenance(oldEquipment.getId(), maintenance.getId()).orElse(null);
                oldEquipment.setMaintenanceDate(date);
            } else if (dto.getDate().isAfter(oldEquipment.getMaintenanceDate())) {
                oldEquipment.setMaintenanceDate(maintenance.getDate());
                equipmentRepository.save(oldEquipment);
            }
        }

        setStatusUpdatedItem(
                maintenance.getStatus() == null ? Status.SCHEDULED : maintenance.getStatus(),
                dto.getStatus() == null ? Status.SCHEDULED : dto.getStatus()
        );
        return dto;
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

    @Override
    public List<Maintenance> findByCriteria(MaintenanceCriteria params) {
        Specification<Maintenance> spec = specification.build(params);
        return repository.findAll(spec);
    }
}
