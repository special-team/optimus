package com.github.ooknight.rubik.support.core.exception;

public interface BusinessExceptionType {

    enum Default implements BusinessExceptionType {
        ENTITY_NOT_FOUND, UNAUTHORIZED_ACCESS
    }
}
