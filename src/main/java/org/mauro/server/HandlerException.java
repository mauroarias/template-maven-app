package org.mauro.server;

import org.mauro.model.Error;
import org.mauro.model.exception.MonitoringBadParametersException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.mauro.model.exception.ErrorType.UNKNOWN_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public final class HandlerException {

	//Monitoring Bad parameter arguments
	@ExceptionHandler(MonitoringBadParametersException.class)
	public ResponseEntity handlerBadParametersException(final MonitoringBadParametersException ex) {
		return new ResponseEntity<>(Error
										.builder()
										.errorType(ex.getErrorType())
										.exceptionType(ex.getClass().getCanonicalName())
										.message(ex.getMessage())
										.build(),
									BAD_REQUEST);
	}

	//unknowns exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity handlerException(Exception ex) {
		return new ResponseEntity<>(Error
										.builder()
										.errorType(UNKNOWN_ERROR)
										.exceptionType(ex.getClass().getCanonicalName())
										.message(ex.getMessage())
										.build(),
									INTERNAL_SERVER_ERROR);
	}
}
