package org.mauro.server;

import org.mauro.service.TemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "template/v1/ping")
public class TemplateController {

	private final TemplateService templateService;

	TemplateController(final TemplateService templateService) {
		this.templateService = templateService;
	}

	@GetMapping(produces = "application/json")
    ResponseEntity ping() {
		return new ResponseEntity<>(templateService.ping(), OK);
	}
}
