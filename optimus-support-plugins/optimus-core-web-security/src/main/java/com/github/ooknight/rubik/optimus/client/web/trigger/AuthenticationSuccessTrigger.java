package com.github.ooknight.rubik.optimus.client.web.trigger;

import com.github.ooknight.rubik.core.client.web.security.authentication.SessionUserAdapter;
import com.github.ooknight.rubik.core.session.Scope;
import com.github.ooknight.rubik.core.session.SessionUser;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Privilege;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.ebean.Expression;
import io.ebeaninternal.server.expression.Op;
import io.ebeaninternal.server.expression.SimpleExpression;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AuthenticationSuccessTrigger implements ApplicationListener<AuthenticationSuccessEvent> {

    private SecurityUserService service;

    public AuthenticationSuccessTrigger(SecurityUserService securityUserService) {
        this.service = securityUserService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        SessionUserAdapter sua = (SessionUserAdapter) event.getAuthentication().getPrincipal();
        Long uid = sua.uid();
        Long rid = sua.rid();
        Long gid = sua.gid();
        boolean admin = sua.admin();
        //
        Set<String> resources;
        Set<String> tags;
        Scope scope;
        //
        tags = Sets.newHashSet("u#" + uid, "r#" + rid, "g#" + gid);
        //
        if (admin) {
            resources = service.getResourceForAdministrator();
            tags.add(SessionUser.TAG_ADMIN);
            scope = Scope.BUILD(uid, rid, gid, true);
        } else {
            Map<Class, Expression> expressions = Maps.newHashMap();
            Set<String> restricteds = Sets.newHashSet();
            Set<Privilege> privileges = service.getPrivilege(rid, gid);
            privileges.forEach(privilege -> {
                Expression exp = new SimpleExpression(
                    privilege.getField(),
                    Op.valueOf(privilege.getOperator()),
                    privilege.getValue().replace("{rid}", rid + "").replace("{gid}", gid + ""));
                expressions.put(privilege.getEntity(), exp);
                restricteds.addAll(Optional.ofNullable(privilege.getRestricted()).orElse(Sets.newHashSet()));
            });
            resources = service.getResource(rid, uid);
            scope = Scope.BUILD(uid, rid, gid, restricteds, expressions, false);
        }
        sua.init(resources, tags, scope);
    }
}
