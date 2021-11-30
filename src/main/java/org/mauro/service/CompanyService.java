package org.mauro.service;

import lombok.extern.slf4j.Slf4j;
import org.mauro.model.Company;
import org.mauro.model.CompanyAnswer;
import org.mauro.model.CompanyPageAnswer;
import org.mauro.postgres.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

/**
 * @author marias
 */
@Service
@Slf4j
public final class CompanyService {

	/**
	 * company repository class
	 */
	private CompanyRepository repository;

	public CompanyService(final CompanyRepository repository) {
		this.repository = repository;
	}

	public CompanyAnswer create(final Company company) {
		log.info("creating company");
		return repository.persist(company);
	}

	public CompanyAnswer get(final UUID id) {
		log.info("get company");
		return repository.get(id);
	}

	public Set<CompanyAnswer> getByName(final String name) {
		log.info("get company");
		return repository.getByName(name);
	}

	public CompanyPageAnswer getAll(final Integer page, final Integer pageSize) {
		log.info("get companies");
		return repository.getAll(page, pageSize);
	}

	public void delete(final UUID id) {
		log.info("deleting company");
		repository.delete(id);
	}
}
