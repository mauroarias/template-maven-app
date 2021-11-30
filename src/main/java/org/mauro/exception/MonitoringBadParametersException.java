package org.mauro.exception;

import lombok.Getter;

import static java.lang.String.format;
import static org.mauro.exception.ErrorType.BAD_ARGUMENTS;

@Getter
public final class MonitoringBadParametersException extends RuntimeException {
	private final ErrorType errorType = BAD_ARGUMENTS;

	public MonitoringBadParametersException(final String message, final Object ... params) {
		super(format(message, params));
	}

	public MonitoringBadParametersException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
