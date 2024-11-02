package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Contractor;
import ru.gb.maintenance.model.dtos.ContractorDto;
import ru.gb.maintenance.model.maps.ContractorMapper;
import ru.gb.maintenance.repositories.ContractorRepository;

@Service
public class ContractorServiceImpl extends BaseEntityServiceImpl<Contractor, ContractorDto, ContractorMapper> implements ContractorService {
    public ContractorServiceImpl(ContractorRepository repository, ContractorMapper mapper) {
        super(repository, mapper);
    }
}
