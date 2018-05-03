package com.github.ooknight.rubik.core.client;

import optimus.TOOLKIT;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BusinessEvent extends ApplicationEvent {

    public BusinessEvent() {
        super(SecurityContextHolder.getContext().getAuthentication());
    }

    @Override
    public String toString() {
        return TOOLKIT.TO_JSON_STRING(this);
    }
}
