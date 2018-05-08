package com.github.ooknight.rubik.optimus.client.web;

import com.github.ooknight.rubik.core.client.web.security.authentication.StandardSessionUserService;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;
import com.github.ooknight.rubik.optimus.client.web.trigger.AuthenticationSuccessTrigger;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private SecurityUserService securityUserService;

    @Bean
    protected AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider r = new DaoAuthenticationProvider();
        r.setHideUserNotFoundExceptions(false);
        r.setUserDetailsService(userDetailsService());
        return r;
    }

    @Bean
    protected AuthenticationSuccessTrigger authenticationSuccessTrigger() {
        return new AuthenticationSuccessTrigger(securityUserService);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new StandardSessionUserService(securityUserService);
    }

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
            .antMatchers("/actuator/**").hasRole("god")
            .antMatchers("/admin/**").hasRole("admin")
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").permitAll()
            .and().logout().invalidateHttpSession(true).permitAll();
    }
}
