package org.mauro.service;

import org.mauro.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public final class TemplateService {

	private final static Logger logger = LoggerFactory.getLogger(TemplateService.class);

	/**
	 * This start the monitoring
	 * @return monitoring setup
	 */
	public Status ping() {
		logger.debug("calling debug");
		return Status.builder().value("PONG").build();
	}
}
