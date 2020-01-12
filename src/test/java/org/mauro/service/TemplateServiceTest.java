package org.mauro.service;

import org.junit.jupiter.api.Test;
import org.mauro.model.Status;

import static org.assertj.core.api.Assertions.assertThat;

final class TemplateServiceTest {

	private TemplateService service = new TemplateService();

	@Test
	void ping() {
		assertThat(service.ping()).isEqualTo(Status.builder().value("PONG").build());
	}
}
