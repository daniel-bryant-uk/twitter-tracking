package uk.co.taidev.projects.twittertracking.exceptions;

/**
 * ExternalServiceUnavailableException is a temporary Class created to indicate that an external service, such as
 * the Twitter API is unavailable.
 * <p>
 * This will eventually be replace by implementing Hystrix to deal with these issues.
 */
public class ExternalServiceUnavailableException extends RuntimeException {

    public ExternalServiceUnavailableException() {
    }

    public ExternalServiceUnavailableException(String message) {
        super(message);
    }

    public ExternalServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExternalServiceUnavailableException(Throwable cause) {
        super(cause);
    }
}
