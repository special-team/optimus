package com.github.ooknight.rubik.support.thymeleaf.expression;

import com.github.ooknight.rubik.prototype.authority.Scope;
import com.github.ooknight.rubik.prototype.authority.SessionUser;

import org.springframework.security.core.context.SecurityContextHolder;

public class SessionUserExpression {

    public boolean has(String code) {
        SessionUser csu = (SessionUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return csu.resources().contains(code);
    }

    public boolean allow(String field) {
        Scope scope = ((SessionUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).scope();
        return !scope.restricteds().contains(field);
    }

    public Scope scope() {
        SessionUser csu = (SessionUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return csu.scope();
    }
}
