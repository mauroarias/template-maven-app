package org.mauro.templateapp.service;

import org.junit.jupiter.api.Test;
import org.mauro.templateapp.model.Status;
import org.mauro.templateapp.service.TemplateService;

import static org.assertj.core.api.Assertions.assertThat;

final class TemplateServiceTest {

	private TemplateService service = new TemplateService();

	@Test
	void ping() {
		assertThat(service.ping()).isEqualTo(Status.builder().value("PONG").build());
	}
}
