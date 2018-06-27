package com.github.ooknight.rubik.optimus.client.web;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityAutoConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
            .antMatchers(HttpMethod.GET, "/**/favicon.ico")
            .antMatchers(HttpMethod.GET, "/actuator/health")
            .antMatchers(HttpMethod.GET, "/static/**")
            .antMatchers(HttpMethod.GET, "/assets/**")
            .antMatchers(HttpMethod.GET, "/login**")
            .antMatchers(HttpMethod.GET, "/remote/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/actuator/**").hasRole("GOD")
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").permitAll()
            .and().logout().invalidateHttpSession(true).permitAll();
    }
}
