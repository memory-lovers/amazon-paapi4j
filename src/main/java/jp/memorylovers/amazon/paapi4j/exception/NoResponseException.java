package jp.memorylovers.amazon.paapi4j.exception;

public class NoResponseException extends PAAPI4jException {

    private static final long serialVersionUID = -6129228863810236209L;

    public NoResponseException(String message) {
        super(message);
    }

    public NoResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoResponseException(Throwable cause) {
        super(cause);
    }
}
