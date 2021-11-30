package org.mauro.openfeigh;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "template/v1/user")
public class UserClientController {

	private final UserClientService userClientService;

    UserClientController(final UserClientService userClientService) {
		this.userClientService = userClientService;
	}

	@GetMapping(produces = "application/json")
	ResponseEntity get() {
		return new ResponseEntity<>(userClientService.getUsers(), OK);
	}

//	@PostMapping(consumes = "application/json", produces = "application/json")
//	ResponseEntity create(final @RequestBody Company company) {
//		return new ResponseEntity<>(templateService.create(company), CREATED);
//	}
//
//	@GetMapping(value = "/{id}", produces = "application/json")
//	ResponseEntity get(final @RequestParam("id") UUID id) {
//		return new ResponseEntity<>(templateService.get(id), OK);
//	}
//
//	@GetMapping(value = "/searchByName/{name}", produces = "application/json")
//	ResponseEntity get(final String name) {
//		return new ResponseEntity<>(templateService.getByName(name), OK);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	ResponseEntity create(final UUID id) {
//    	templateService.delete(id);
//		return new ResponseEntity<>(OK);
//	}
}
