package com.github.ooknight.rubik.optimus.kernel.platform;

import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;
import com.github.ooknight.rubik.optimus.kernel.KernelAutoConfiguration;
import com.github.ooknight.rubik.optimus.kernel.platform.service.impl.PlatformServiceImpl;
import com.github.ooknight.rubik.optimus.kernel.platform.service.impl.SecurityUserServiceImpl;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@ImportAutoConfiguration(KernelAutoConfiguration.class)
public class PlatformAutoConfiguration {

    @Bean
    protected PlatformService platformService() {
        return new PlatformServiceImpl();
    }

    @Bean
    protected SecurityUserService securityUserService() {
        return new SecurityUserServiceImpl();
    }
}
