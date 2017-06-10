package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

public class RequestThrottledException extends PAAPI4jException {
    private static final long serialVersionUID = 1708265505058880400L;

    public RequestThrottledException(String message) {
        super(message);
    }

    public RequestThrottledException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestThrottledException(Throwable cause) {
        super(cause);
    }
}
