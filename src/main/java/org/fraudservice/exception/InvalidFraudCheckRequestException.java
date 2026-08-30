package org.fraudservice.exception;

public class InvalidFraudCheckRequestException extends RuntimeException{
    public InvalidFraudCheckRequestException(String message) {
        super(message);
    }
}
