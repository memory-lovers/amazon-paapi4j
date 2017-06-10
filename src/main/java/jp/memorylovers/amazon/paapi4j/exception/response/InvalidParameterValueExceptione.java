package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

public class InvalidParameterValueExceptione extends PAAPI4jException {
    private static final long serialVersionUID = 5886105103007594477L;

    public InvalidParameterValueExceptione(String message) {
        super(message);
    }

    public InvalidParameterValueExceptione(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParameterValueExceptione(Throwable cause) {
        super(cause);
    }
}
