package com.github.ooknight.rubik.core.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class BusinessEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void publish(BusinessEvent event) {
        context.publishEvent(event);
        log.debug("business event publish success {}", event);
    }

    /*
    //@ExceptionHandler(RuntimeException.class)
    //public void foo() {
    //    logger.error("business event publish error");
    //}
    */
}
