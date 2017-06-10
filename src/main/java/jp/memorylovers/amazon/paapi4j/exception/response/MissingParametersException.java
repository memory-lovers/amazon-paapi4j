package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

public class MissingParametersException extends PAAPI4jException {
    private static final long serialVersionUID = -7302546294615064705L;

    public MissingParametersException(String message) {
        super(message);
    }

    public MissingParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingParametersException(Throwable cause) {
        super(cause);
    }
}
