package org.mauro.server;

import org.mauro.model.Company;
import org.mauro.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "template/v1/company")
public class CompanyController {

	private final CompanyService templateService;

    CompanyController(final CompanyService templateService) {
		this.templateService = templateService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity create(final @RequestBody Company company) {
		return new ResponseEntity<>(templateService.create(company), OK);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	ResponseEntity get(final Integer id) {
		return new ResponseEntity<>(templateService.get(id), OK);
	}

	@GetMapping(produces = "application/json")
	ResponseEntity getAll() {
		return new ResponseEntity<>(templateService.getAll(), OK);
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity create(final Integer id) {
    	templateService.delete(id);
		return new ResponseEntity<>(OK);
	}
}
