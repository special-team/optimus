package com.github.ooknight.rubik.optimus.archer.platform.service;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QAccount;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QGroup;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QRole;

import java.util.List;
import java.util.Optional;

public interface PlatformService {

    void create(Role role);

    void update(Role role);

    Optional<Role> role(Long id);

    List<Role> role();

    QRole createRoleQuery();

    void create(Group group);

    void update(Group group);

    Optional<Group> group(Long id);

    List<Group> group();

    QGroup createGroupQuery();

    void create(Account account);

    void update(Account account);

    Optional<Account> account(Long id);

    List<Account> account();

    QAccount createAccountQuery();

    List<Module> menu();

    List<Function> shortcut();

    void changeAccountPassword(Long accountId, String password);
}
