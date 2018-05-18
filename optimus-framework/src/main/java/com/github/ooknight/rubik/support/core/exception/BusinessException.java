package com.github.ooknight.rubik.support.core.exception;

import com.google.common.base.MoreObjects;

public class BusinessException extends RuntimeException {

    public static final String PREFIX = "exception.business.";
    //
    private Type key;
    private Object[] args;

    public BusinessException(Type key, Object... args) {
        super(key.toString());
        this.key = key;
        this.args = args;
    }

    public BusinessException(Type key, Throwable cause, Object... args) {
        super(key.toString(), cause);
        this.key = key;
        this.args = args;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("key", key)
            .add("args", args)
            .toString();
    }

    public enum Type {
        ENTITY_NOT_FOUND,
        UNAUTHORIZED_ACCESS
    }
}
