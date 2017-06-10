package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

public class RequestExpiredException extends PAAPI4jException {
    private static final long serialVersionUID = 1925371259757243559L;

    public RequestExpiredException(String message) {
        super(message);
    }

    public RequestExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestExpiredException(Throwable cause) {
        super(cause);
    }
}
