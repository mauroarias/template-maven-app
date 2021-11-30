package org.mauro.postgres;

import org.mauro.postgres.model.CompanyDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

//CrudRepository
public interface JpaCompanyRepository extends PagingAndSortingRepository<CompanyDao, UUID> {
    @Query(value = "select * from company where data ->> 'name' = :name" , nativeQuery = true)
    List<CompanyDao> findByName(@Param("name") String name);
}
