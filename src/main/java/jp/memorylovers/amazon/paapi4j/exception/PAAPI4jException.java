package jp.memorylovers.amazon.paapi4j.exception;

public class PAAPI4jException extends Exception {
    private static final long serialVersionUID = -4486493257663869034L;

    public PAAPI4jException(String message) {
        super(message);
    }

    public PAAPI4jException(String message, Throwable cause) {
        super(message, cause);
    }

    public PAAPI4jException(Throwable cause) {
        super(cause);
    }
}
