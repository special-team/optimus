package com.github.ooknight.rubik.optimus.kernel;

import com.github.ooknight.rubik.core.kernel.DBContext;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptKeyManager;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptor;
import com.github.ooknight.rubik.support.ebean.LoggingSlowQueryListener;

import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootConfiguration
@EnableCaching(order = 1)
@EnableTransactionManagement(order = 2)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({DataSourceAutoConfiguration.class, CacheAutoConfiguration.class})
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
        config.setExpressionEqualsWithNullAsNoop(true);
        config.setSlowQueryMillis(3000L);
        config.setSlowQueryListener(new LoggingSlowQueryListener());
        config.setEncryptKeyManager(new DefaultEncryptKeyManager());
        config.setEncryptor(new DefaultEncryptor());
        return new DBContext(EbeanServerFactory.create(config));
    }
}
