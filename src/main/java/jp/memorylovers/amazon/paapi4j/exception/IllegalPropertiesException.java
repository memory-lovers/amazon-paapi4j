package jp.memorylovers.amazon.paapi4j.exception;

public class IllegalPropertiesException extends PAAPI4jException {

    private static final long serialVersionUID = 638709284528609597L;

    public IllegalPropertiesException(String message) {
        super(message);
    }

    public IllegalPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalPropertiesException(Throwable cause) {
        super(cause);
    }
}
