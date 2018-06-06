package com.github.ooknight.rubik.optimus.client.web;

import optimus.TOOLKIT;
import com.github.ooknight.rubik.core.client.BusinessEventPublisher;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootConfiguration
@Import(SpringDataWebAutoConfiguration.class)
public class WebAutoConfiguration implements WebMvcConfigurer {

    @Bean
    protected BusinessEventPublisher businessEventPublisher() {
        return new BusinessEventPublisher();
    }

    @Bean
    protected LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    /*
     * setUseSuffixPatternMatch : 设置是否匹配后缀模式, 如 '/demo' 是否匹配 '/user.*', 默认真即匹配
     * setUseTrailingSlashMatch : 设置是否匹配路径模式, 如 '/demo' 是否匹配 '/user/', 默认真即匹配
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(false).setUseSuffixPatternMatch(false);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar jsr310 = new DateTimeFormatterRegistrar();
        jsr310.setDateTimeFormatter(TOOLKIT.DATE_TIME_FORMATTER);
        jsr310.setDateFormatter(TOOLKIT.DATE_FORMATTER);
        jsr310.setTimeFormatter(TOOLKIT.TIME_FORMATTER);
        jsr310.registerFormatters(registry);
    }
}
