package com.github.ooknight.rubik.support.core.exception;

import optimus.TOOLKIT;

import com.google.common.collect.ImmutableList;

public class BusinessException extends RuntimeException {

    /* public static final String PREFIX = "exception.business."; */

    public BusinessException(Enum<? extends BusinessExceptionType> key, Object... args) {
        super(TOOLKIT.MESSAGE("BUSINESS_EXCEPTION.%s:%s", key, ImmutableList.copyOf(args)));
    }

    public BusinessException(Enum<? extends BusinessExceptionType> key, Throwable cause, Object... args) {
        super(TOOLKIT.MESSAGE("BUSINESS_EXCEPTION.%s:%s", key, ImmutableList.copyOf(args)), cause);
    }

    public enum Type implements BusinessExceptionType {
        ENTITY_NOT_FOUND, UNAUTHORIZED_ACCESS,
    }
}
