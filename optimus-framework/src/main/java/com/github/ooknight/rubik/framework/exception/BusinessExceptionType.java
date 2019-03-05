package com.github.ooknight.rubik.framework.exception;

public interface BusinessExceptionType {

    enum Default implements BusinessExceptionType {
        ENTITY_NOT_FOUND, UNAUTHORIZED_ACCESS, SERVICE_NOT_SUPPORT
    }
}
