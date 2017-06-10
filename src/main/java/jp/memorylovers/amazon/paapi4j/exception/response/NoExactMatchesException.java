package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

public class NoExactMatchesException extends PAAPI4jException {
    private static final long serialVersionUID = 7045267899125156659L;

    public NoExactMatchesException(String message) {
        super(message);
    }

    public NoExactMatchesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoExactMatchesException(Throwable cause) {
        super(cause);
    }
}
