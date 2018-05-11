package com.github.ooknight.rubik.optimus.client.web;

import optimus.TOOLKIT;
import com.github.ooknight.rubik.core.client.BusinessEventPublisher;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    protected BusinessEventPublisher businessEventPublisher() {
        return new BusinessEventPublisher();
    }

    @Bean
    protected LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Bean
    protected LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /*
     * setUseSuffixPatternMatch : 设置是否匹配后缀模式, 如 '/demo' 是否匹配 '/user.*', 默认真即匹配
     * setUseTrailingSlashMatch : 设置是否匹配路径模式, 如 '/demo' 是否匹配 '/user/', 默认真即匹配
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(false).setUseSuffixPatternMatch(false);
    }

    //@Override
    //public void addFormatters(FormatterRegistry registry) {
    //    DateTimeFormatterRegistrar jsr310 = new DateTimeFormatterRegistrar();
    //    jsr310.setDateTimeFormatter(DateTimeFormatter.ofPattern(TOOLKIT.DATE_TIME_FROMAT));
    //    jsr310.setDateFormatter(DateTimeFormatter.ofPattern(TOOLKIT.DATE_FROMAT));
    //    jsr310.setTimeFormatter(DateTimeFormatter.ofPattern(TOOLKIT.TIME_FORMAT));
    //    jsr310.registerFormatters(registry);
    //}
}
