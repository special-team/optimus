package com.github.ooknight.rubik.core.client;

import optimus.TOOLKIT;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BusinessEvent extends ApplicationEvent {

    public BusinessEvent() {
        super(authentication());
    }

    private static Authentication authentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            authentication = new AnonymousAuthenticationToken("key", "anonymous", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
        }
        return authentication;
    }

    @Override
    public String toString() {
        return TOOLKIT.TO_JSON_STRING(this);
    }
}
