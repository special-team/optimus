package com.github.ooknight.rubik.optimus.archer.platform.service;

import com.github.ooknight.rubik.core.service.IService;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Setting;

import java.util.List;

public interface PlatformService extends IService {

    void create(Account account);

    void update(Account account);

    void create(Group group);

    void update(Group group);

    void create(Role role);

    void update(Role role);

    List<Module> menu();

    List<Function> shortcut();

    String setting(Setting.KEY key);

    void setting(Setting.KEY key, String value);

    void changeAccountPassword(Long accountId, String password);
}
