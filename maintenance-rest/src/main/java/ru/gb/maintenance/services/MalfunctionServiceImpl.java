package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.maintenance.model.Malfunction;
import ru.gb.maintenance.model.dtos.MalfunctionDto;
import ru.gb.maintenance.model.maps.MalfunctionMapper;
import ru.gb.maintenance.repositories.MalfunctionRepository;

import java.util.List;

@Service
public class MalfunctionServiceImpl extends BaseEntityServiceImpl<Malfunction, MalfunctionDto, MalfunctionMapper> implements MalfunctionService{
    private final MalfunctionRepository malfunctionRepository;
    public MalfunctionServiceImpl(MalfunctionRepository malfunctionRepository, MalfunctionMapper mapper, MalfunctionRepository repository) {
        super(repository, mapper);
        this.malfunctionRepository = malfunctionRepository;
    }

    @GetMapping
    @Override
    public List<MalfunctionDto> findByMaintenanceId(Long id) {
        return mapper.toDtoList(malfunctionRepository.findByMaintenanceId(id));
    }

    @Override
    public void deleteByMaintenanceId(Long id) {
        malfunctionRepository.deleteByMaintenanceId(id);
    }
}
