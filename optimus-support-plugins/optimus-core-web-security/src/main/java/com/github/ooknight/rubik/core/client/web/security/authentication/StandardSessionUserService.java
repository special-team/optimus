package com.github.ooknight.rubik.core.client.web.security.authentication;

import com.github.ooknight.rubik.core.entity.Active;
import com.github.ooknight.rubik.core.session.AccountType;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class StandardSessionUserService implements UserDetailsService {

    private SecurityUserService userService;

    public StandardSessionUserService(SecurityUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String _username) throws UsernameNotFoundException {
        Account account = userService.getAccount(_username).orElseThrow(() -> new UsernameNotFoundException(_username));
        Long uid = account.getId();
        Long rid = account.getRole() == null ? null : account.getRole().getId();
        Long gid = account.getGroup() == null ? null : account.getGroup().getId();
        String name = account.getUsername();
        String password = account.getPassword();
        AccountType type = account.getType();
        Active active = account.active();
        return new SessionUserAdapter(uid, rid, gid, name, password, type, active);
    }
}
