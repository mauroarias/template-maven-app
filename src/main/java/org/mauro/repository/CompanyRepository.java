package org.mauro.repository;

import org.mauro.model.Company;
import org.mauro.model.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import static org.mauro.repository.model.CompanyMapper.MAPPER;

@Repository
public class CompanyRepository {

    private JpaCompanyRepository jpaCompanyRepository;

    public CompanyRepository(JpaCompanyRepository jpaCompanyRepository) {
        this.jpaCompanyRepository = jpaCompanyRepository;
    }

    public Company persist(final Company company) {
        return MAPPER.fromCompanyDao(jpaCompanyRepository.save(MAPPER.toCompanyDao(company)));
    }

    public Company get(final Integer id) {
        return MAPPER.fromCompanyDao(jpaCompanyRepository.findById(id).orElseThrow(() -> new NotFoundException("company %s not found", id)));
    }

    public Set<Company> getAll() {
        final Set<Company> companies = new HashSet<>();
        jpaCompanyRepository.findAll().forEach(companyDao -> companies.add(MAPPER.fromCompanyDao(companyDao)));
        return companies;
    }

    public void delete(final Integer id) {
        jpaCompanyRepository.deleteById(id);
    }
}
