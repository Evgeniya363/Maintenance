package ru.gb.maintenance.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.maintenance.model.Company;

public interface CompanyRepository  extends JpaRepository<Company, Long> {
}
