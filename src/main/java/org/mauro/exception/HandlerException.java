package org.mauro.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.mauro.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.mauro.exception.ErrorType.UNKNOWN_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public final class HandlerException {

	@ExceptionHandler(MonitoringBadParametersException.class)
	public ResponseEntity handlerException(final MonitoringBadParametersException ex) {
		return buildAndLog(ex.getErrorType(), BAD_REQUEST, ex);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity handlerException(final NotFoundException ex) {
		return buildAndLog(ex.getErrorType(), NOT_FOUND, ex);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity handlerException(Exception ex) {
		return buildAndLog(UNKNOWN_ERROR, INTERNAL_SERVER_ERROR, ex);
	}

	private ResponseEntity buildAndLog(final ErrorType errorType, final HttpStatus status, final Exception ex) {
		log.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(Error
				.builder()
				.errorType(errorType)
				.exceptionType(ex.getClass().getCanonicalName())
				.message(ex.getMessage())
				.build(),
				status);
	}
}
