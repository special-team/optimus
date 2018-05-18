package com.github.ooknight.rubik.optimus.kernel.platform.service.impl;

import com.github.ooknight.rubik.core.kernel.DBContext;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QAccount;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QGroup;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QRole;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QSetting;
import com.github.ooknight.rubik.optimus.archer.platform.enums.DisplayMode;
import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Resource
    private DBContext db;

    @Override
    public void create(Account account) {
        db.insert(account);
    }

    @Override
    public void update(Account account) {
        db.update(account);
    }

    @Override
    public Optional<Account> account(Long id) {
        return db.getone(Account.class, id);
    }

    @Override
    public List<Account> account() {
        return db.select(Account.class);
    }

    @Override
    public void create(Group group) {
        db.insert(group);
    }

    @Override
    public void update(Group group) {
        db.update(group);
    }

    @Override
    public Optional<Group> group(Long id) {
        return db.getone(Group.class, id);
    }

    @Override
    public List<Group> group() {
        return db.select(Group.class);
    }

    @Override
    public void create(Role role) {
        db.insert(role);
    }

    @Override
    public void update(Role role) {
        db.update(role);
    }

    @Override
    public Optional<Role> role(Long id) {
        return db.getone(Role.class, id);
    }

    @Override
    public List<Role> role() {
        return db.select(Role.class);
    }

    @Cacheable("menu")
    @Override
    public List<Module> menu() {
        //TODO JOIN 查询实现
        return db.createQuery(Module.class)
            .filterMany("function").in("display", DisplayMode.MENU, DisplayMode.MENU_AND_SHORTCUT)
            .orderBy("ordinal")
            .findList();
    }

    @Cacheable("shortcut")
    @Override
    public List<Function> shortcut() {
        return db.createQuery(Function.class).where().in("display", DisplayMode.SHORTCUT, DisplayMode.MENU_AND_SHORTCUT)
            .orderBy("ordinal")
            .findList();
    }

    @Override
    public void changeAccountPassword(Long accountId, String password) {
        db.update(Account.class).set("password", password).where().idEq(accountId).update();
    }
}
