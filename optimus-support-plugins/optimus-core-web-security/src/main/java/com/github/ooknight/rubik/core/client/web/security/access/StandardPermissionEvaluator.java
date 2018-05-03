package com.github.ooknight.rubik.core.client.web.security.access;

import com.github.ooknight.rubik.core.session.SessionUser;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class StandardPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        SessionUser su = (SessionUser) authentication.getPrincipal();
        return su.resources().contains(targetDomainObject.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        ///
        //System.out.println("=========================================================================== 2 ");
        //System.out.println(targetId);
        //System.out.println(targetType);
        //System.out.println(permission);
        return false;
    }
}
