package com.github.ooknight.rubik.optimus.kernel;

import com.github.ooknight.rubik.prime.constant.AspectOrder;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptKeyManager;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptor;
import com.github.ooknight.rubik.support.ebean.LoggingSlowQueryListener;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootConfiguration
@EnableCaching(order = AspectOrder.CACHE)
@EnableTransactionManagement(order = AspectOrder.TRANSACTION)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportAutoConfiguration({DataSourceAutoConfiguration.class, CacheAutoConfiguration.class})
public class KernelConfiguration {

    @Resource
    private DataSource dataSource;

    /*
    @Bean
    public org.jasypt.util.text.TextEncryptor textEncryptor() {
        BasicTextEncryptor basicTextEncryptor = new org.jasypt.util.text.BasicTextEncryptor();
        basicTextEncryptor.setPassword(password);
        return basicTextEncryptor;
    }
    */

    @Bean
    public Database database() {
        DatabaseConfig config = new DatabaseConfig();
        config.setDataSource(dataSource);
        config.setAutoCommitMode(true);
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());
        config.setExpressionEqualsWithNullAsNoop(true);
        config.setSlowQueryMillis(3000L);
        config.setSlowQueryListener(new LoggingSlowQueryListener());
        config.setEncryptKeyManager(new DefaultEncryptKeyManager());
        config.setEncryptor(new DefaultEncryptor());
        config.setDisableLazyLoading(true);
        return DatabaseFactory.create(config);
    }
}
