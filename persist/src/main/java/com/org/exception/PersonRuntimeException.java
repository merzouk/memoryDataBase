package com.org.exception;

public class PersonRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 4598678758218070254L;

    public PersonRuntimeException() {
        // TODO Auto-generated constructor stub
    }

    public PersonRuntimeException(String message) {
        super(message);
    }

    public PersonRuntimeException(Throwable cause) {
        super(cause);
    }

    public PersonRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
