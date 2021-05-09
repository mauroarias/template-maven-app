package org.mauro.repository;

import org.mauro.repository.model.CompanyDao;
import org.springframework.data.repository.CrudRepository;

public interface JpaCompanyRepository extends CrudRepository<CompanyDao, Integer> {
}
