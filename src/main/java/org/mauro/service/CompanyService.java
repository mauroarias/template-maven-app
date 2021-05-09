package org.mauro.service;

import lombok.extern.slf4j.Slf4j;
import org.mauro.model.Company;
import org.mauro.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public final class CompanyService {

	private CompanyRepository repository;

	public CompanyService(final CompanyRepository repository) {
		this.repository = repository;
	}

	public Company create(final Company company) {
		log.info("creating company");
		return repository.persist(company);
	}

	public Company get(final Integer id) {
		log.info("get company");
		return repository.get(id);
	}

	public Set<Company> getByName(final String name) {
		log.info("get company");
		return repository.getByName(name);
	}

	public Set<Company> getAll() {
		log.info("get companies");
		return repository.getAll();
	}

	public void delete(final Integer id) {
		log.info("deleting company");
		repository.delete(id);
	}
}
