package com.github.ooknight.rubik.optimus.kernel;

import com.github.ooknight.rubik.core.kernel.DBContext;
import com.github.ooknight.rubik.support.ebean.LoggingSlowQueryListener;

import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootConfiguration
@EnableCaching(order = 1)
@EnableTransactionManagement(order = 2)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class KernelAutoConfiguration {

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
    public DBContext db() {
        ServerConfig config = new ServerConfig();
        config.setDataSource(dataSource);
        config.setAutoCommitMode(true);
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());
        config.setDatabaseBooleanTrue("1");
        config.setDatabaseBooleanFalse("0");
        config.setSlowQueryMillis(3000L);
        config.setSlowQueryListener(new LoggingSlowQueryListener());
        return new DBContext(EbeanServerFactory.create(config));
    }
}
