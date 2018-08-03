package com.github.ooknight.rubik.support.core.exception;

import optimus.TOOLKIT;

import com.google.common.collect.ImmutableList;

public class BusinessException extends RuntimeException {

    /* public static final String PREFIX = "exception.business."; */

    public <T extends Enum & BusinessExceptionType> BusinessException(T key, Object... args) {
        super(TOOLKIT.MESSAGE("BUSINESS_EXCEPTION.%s:%s", key, ImmutableList.copyOf(args)));
    }

    public <T extends Enum & BusinessExceptionType> BusinessException(T key, Throwable cause, Object... args) {
        super(TOOLKIT.MESSAGE("BUSINESS_EXCEPTION.%s:%s", key, ImmutableList.copyOf(args)), cause);
    }
}
