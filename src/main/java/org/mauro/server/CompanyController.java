package org.mauro.server;

import org.mauro.model.Company;
import org.mauro.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "template/v1/company")
public class CompanyController {

	private final CompanyService templateService;

    CompanyController(final CompanyService templateService) {
		this.templateService = templateService;
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	ResponseEntity create(final @RequestBody Company company) {
		return new ResponseEntity<>(templateService.create(company), CREATED);
	}

	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	ResponseEntity get(@PathParam("id") final String id) {
		return new ResponseEntity<>(templateService.get(UUID.fromString(id)), OK);
	}

	@GetMapping(value = "/searchByName/{name}", produces = APPLICATION_JSON_VALUE)
	ResponseEntity getByName(final String name) {
		return new ResponseEntity<>(templateService.getByName(name), OK);
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	ResponseEntity getAll(@RequestParam(defaultValue = "0") @Min(0) final Integer page,
						  @RequestParam(defaultValue = "10") @Min(0)final Integer pageSize) {
		return new ResponseEntity<>(templateService.getAll(page, pageSize), OK);
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity delete(@PathParam("id") final String id) {
    	templateService.delete(UUID.fromString(id));
		return new ResponseEntity<>(OK);
	}
}
