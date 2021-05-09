package org.mauro.repository;

import org.mauro.repository.model.CompanyDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaCompanyRepository extends CrudRepository<CompanyDao, Integer> {
    @Query(value = "select * from company where data ->> 'name' = :name" , nativeQuery = true)
    List<CompanyDao> findByName(@Param("name") String name);

}
