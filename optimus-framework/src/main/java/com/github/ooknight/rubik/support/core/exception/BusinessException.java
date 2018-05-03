package com.github.ooknight.rubik.support.core.exception;

public class BusinessException extends RuntimeException {

    public static final String PREFIX = "exception.business.";

    public BusinessException(String key) {
        super(PREFIX + key);
    }

    public BusinessException(String key, Throwable cause) {
        super(PREFIX + key, cause);
    }
}
