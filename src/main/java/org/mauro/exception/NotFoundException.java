package org.mauro.exception;

import lombok.Getter;

import static java.lang.String.format;
import static org.mauro.exception.ErrorType.NOT_FOUND;

@Getter
public class NotFoundException extends RuntimeException {
    private final ErrorType errorType = NOT_FOUND;

    public NotFoundException(final String message, final Object ... params) {
        super(format(message, params));
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
