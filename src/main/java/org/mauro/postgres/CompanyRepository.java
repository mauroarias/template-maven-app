package org.mauro.postgres;

import org.mauro.exception.NotFoundException;
import org.mauro.model.Company;
import org.mauro.model.CompanyAnswer;
import org.mauro.model.CompanyPageAnswer;
import org.mauro.postgres.model.CompanyDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.mauro.postgres.model.CompanyMapper.MAPPER;

@Repository
public class CompanyRepository {

    private JpaCompanyRepository jpaCompanyRepository;

    public CompanyRepository(JpaCompanyRepository jpaCompanyRepository) {
        this.jpaCompanyRepository = jpaCompanyRepository;
    }

    public CompanyAnswer persist(final Company company) {
        final CompanyDao companyDao = new CompanyDao();
        companyDao.setCompany(MAPPER.toCompanyDto(company));
        return MAPPER.fromCompanyDto(jpaCompanyRepository.save(companyDao));
    }

    public CompanyAnswer get(final UUID id) {
        return MAPPER.fromCompanyDto(jpaCompanyRepository.findById(id).orElseThrow(() -> new NotFoundException("company %s not found", id)));
    }


    public Set<CompanyAnswer> getByName(final String name) {
        return jpaCompanyRepository.findByName(name).stream().map(MAPPER::fromCompanyDto).collect(Collectors.toSet());
    }

    public CompanyPageAnswer getAll(final int page, final int pageSize) {
        final Page<CompanyDao> companies = jpaCompanyRepository.findAll(PageRequest.of(page, pageSize));
        return CompanyPageAnswer.builder()
                .page(companies.getNumber())
                .pageSize(companies.getSize())
                .totalPages(companies.getTotalPages())
                .totalItems(companies.getTotalElements())
                .companies(companies.get().map(MAPPER::fromCompanyDto).collect(Collectors.toList()))
                .build();
    }

    public void delete(final UUID id) {
        jpaCompanyRepository.deleteById(id);
    }
}
