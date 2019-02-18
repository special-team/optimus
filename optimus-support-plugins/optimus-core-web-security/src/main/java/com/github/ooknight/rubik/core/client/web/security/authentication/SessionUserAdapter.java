package com.github.ooknight.rubik.core.client.web.security.authentication;

import com.github.ooknight.rubik.core.entity.State;
import com.github.ooknight.rubik.prototype.authority.Scope;
import com.github.ooknight.rubik.prototype.authority.SessionUser;
import com.github.ooknight.rubik.prototype.authority.SessionUserType;

import com.google.common.collect.Sets;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Set;

public final class SessionUserAdapter implements SessionUser, UserDetails, CredentialsContainer {

    private Long uid;
    private Long rid;
    private Long gid;
    private String name;
    private String password;
    private SessionUserType type;
    private State state;
    private Collection<GrantedAuthority> authorities;
    private Set<String> resources = Sets.newHashSet();
    private Set<String> tags = Sets.newHashSet();
    private Scope scope = Scope.DUMMY();

    public SessionUserAdapter(Long uid, Long rid, Long gid, String name, String password, SessionUserType type, State state) {
        Assert.hasText(name, "SessionUser 创建失败 : 用户名非法");
        Assert.isTrue(state.code() > 0, "SessionUser 创建失败 : 状态异常");
        this.uid = uid;
        this.rid = rid;
        this.gid = gid;
        this.name = name;
        this.password = password;
        this.type = type;
        this.state = state;
        this.authorities = parseAuthorities();
    }

    public void init(Set<String> resources, Set<String> tags, Scope scope) {
        this.resources = resources;
        this.tags = tags;
        this.scope = scope;
    }

    private Collection<GrantedAuthority> parseAuthorities() {
        Set<GrantedAuthority> result = Sets.newHashSet(new SimpleGrantedAuthority("ROLE_USER"));
        //if (this.type == AccountType.ADMIN) {
        //    result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        //}
        //if (this.type == AccountType.GOD) {
        //    result.add(new SimpleGrantedAuthority("ROLE_GOD"));
        //}
        return result;
    }

    /* ========= ========= ========= ========= ========= ========= ========= ========= ========= implements SessionUser */

    @Override
    public Long uid() {
        return this.uid;
    }

    @Override
    public Long rid() {
        return this.rid;
    }

    @Override
    public Long gid() {
        return this.gid;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public SessionUserType type() {
        return this.type;
    }

    @Override
    public Set<String> resources() {
        return this.resources;
    }

    @Override
    public Set<String> tags() {
        return this.tags;
    }

    @Override
    public Scope scope() {
        return this.scope;
    }

    /* ========= ========= ========= ========= ========= ========= ========= ========= ========= implements UserDetails */

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.state.code() >= 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.state.code() >= 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.state.code() >= 0;
    }

    @Override
    public boolean isEnabled() {
        return this.state.code() >= 0;
    }

    /* ========= ========= ========= ========= ========= ========= ========= ========= ========= implements CredentialsContainer */

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    /* ========= ========= ========= ========= ========= ========= ========= ========= =========  */

    public Scope getScope() {
        return scope;
    }
}
