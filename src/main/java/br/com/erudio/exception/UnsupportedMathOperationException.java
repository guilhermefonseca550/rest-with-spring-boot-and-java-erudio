package br.com.erudio.exception;

public class UnsuportedMathOperationException extends RuntimeException {
    public UnsuportedMathOperationException(String message) {
        super(message);
    }
}
