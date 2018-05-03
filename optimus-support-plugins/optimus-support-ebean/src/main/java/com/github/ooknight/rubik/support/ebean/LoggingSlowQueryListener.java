package com.github.ooknight.rubik.support.ebean;

import io.ebean.config.SlowQueryEvent;
import io.ebean.config.SlowQueryListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingSlowQueryListener implements SlowQueryListener {

    private final static Logger logger = LoggerFactory.getLogger(SlowQueryListener.class);

    @Override
    public void process(SlowQueryEvent event) {
        logger.warn("Slow query : {}", event);
    }
}
