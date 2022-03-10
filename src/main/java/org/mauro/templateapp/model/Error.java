package org.mauro.templateapp.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import org.mauro.templateapp.model.exception.ErrorType;

@Value
@Builder
@ToString
//Immutable error bean returned when an exception is triggered
public final class Error {
	//Exception's message
	private final String message;
	//Error number, this could be replaced by just the exception name or something else according to the pattern used
	private final ErrorType errorType;
	//Exception type.
	private final String exceptionType;
}
