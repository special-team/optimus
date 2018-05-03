package com.github.ooknight.rubik.optimus.kernel.platform.service.impl;

import com.github.ooknight.rubik.core.kernel.DBContext;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Privilege;
import com.github.ooknight.rubik.optimus.archer.platform.entity.query.QAccount;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {

    @Resource
    private DBContext db;

    @Override
    public Optional<Account> getAccount(String username) {
        /// use query bean
        //return agent.getAccountByUsername(username);
        //return db.createQuery(Account.class).fetch("role").fetch("group").where().eq("username", username).findOneOrEmpty();
        return new QAccount().role.fetch().group.fetch().username.equalTo(username).findOneOrEmpty();
    }

    @Override
    public Set<String> getResource(Long role, Long account) {
        List<String> r1 = db.createNamedQuery(Function.class, "get-role-resource").setParameter("id", role).findSingleAttributeList();
        List<String> r2 = db.createNamedQuery(Function.class, "get-account-resource").setParameter("id", account).findSingleAttributeList();
        Set<String> result = Sets.newHashSet();
        result.addAll(r1);
        result.addAll(r2);
        return result;
    }

    @Override
    public Set<String> getResourceForAdministrator() {
        return Sets.newHashSet(db.createNamedQuery(Function.class, "get-resource-for-administrator").findSingleAttributeList());
    }

    @Override
    public Set<Privilege> getPrivilege(Long role, Long group) {
        return db.createQuery(Privilege.class).where()
            .or().eq("role", role).eq("group", group).endOr()
            .findSet();
    }
}
