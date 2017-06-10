package jp.memorylovers.amazon.paapi4j.exception;

public class MissingPropertiesException extends PAAPI4jException {

    private static final long serialVersionUID = -2236514040836669947L;

    public MissingPropertiesException(String message) {
        super(message);
    }

    public MissingPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingPropertiesException(Throwable cause) {
        super(cause);
    }
}
