package com.github.ooknight.rubik.optimus.archer.platform.service;

import com.github.ooknight.rubik.core.service.IService;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Privilege;

import java.util.Optional;
import java.util.Set;

public interface SecurityUserService extends IService {

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    Optional<Account> getAccount(String username);

    Set<String> getResource(Long role, Long account);

    Set<String> getResourceForSupervisor();

    Set<Privilege> getPrivilege(Long role, Long group);
}
