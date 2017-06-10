package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

public class InvalidAssociateException extends PAAPI4jException {
    private static final long serialVersionUID = 4627463760035788433L;

    public InvalidAssociateException(String message) {
        super(message);
    }

    public InvalidAssociateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAssociateException(Throwable cause) {
        super(cause);
    }
}
