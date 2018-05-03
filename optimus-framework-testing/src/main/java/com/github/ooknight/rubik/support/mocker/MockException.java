package com.github.ooknight.rubik.support.mocker;

public class MockException extends RuntimeException {

    public MockException(String message) {
        super(message);
    }

    public MockException(String message, Throwable cause) {
        super(message, cause);
    }

    public MockException(Throwable cause) {
        super(cause);
    }
}
