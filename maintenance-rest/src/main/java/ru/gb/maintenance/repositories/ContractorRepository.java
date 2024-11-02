package ru.gb.maintenance.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Contractor;

@Repository
public interface ContractorRepository extends BaseEntityRepository<Contractor> {
}
