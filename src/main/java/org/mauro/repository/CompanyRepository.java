package org.mauro.repository;

import org.mauro.model.Company;
import org.mauro.model.exception.NotFoundException;
import org.mauro.repository.model.CompanyDao;
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
        final CompanyDao companyDao = new CompanyDao();
        companyDao.setCompany(MAPPER.toCompanyDto(company));
        return MAPPER.fromCompanyDto(jpaCompanyRepository.save(companyDao).getCompany());
    }

    public Company get(final Integer id) {
        return MAPPER.fromCompanyDto(jpaCompanyRepository.findById(id).orElseThrow(() -> new NotFoundException("company %s not found", id)).getCompany());
    }

    public Set<Company> getAll() {
        final Set<Company> companies = new HashSet<>();
        jpaCompanyRepository.findAll().forEach(companyDao -> companies.add(MAPPER.fromCompanyDto(companyDao.getCompany())));
        return companies;
    }

    public void delete(final Integer id) {
        jpaCompanyRepository.deleteById(id);
    }
}
