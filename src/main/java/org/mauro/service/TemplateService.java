package org.mauro.service;

import lombok.extern.slf4j.Slf4j;
import org.mauro.model.Status;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class TemplateService {

	/**
	 * This start the monitoring
	 * @return monitoring setup
	 */
	public Status ping() {
		log.debug("calling debug");
		return Status.builder().value("PONG").build();
	}
}
