package com.github.ooknight.rubik.support.ignite.logger;

import org.apache.ignite.IgniteLogger;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardLogger implements IgniteLogger {

    private final Logger log;

    public StandardLogger() {
        this(LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME));
    }

    public StandardLogger(Logger log) {
        this.log = log;
    }

    @Override
    public StandardLogger getLogger(Object ctgr) {
        Logger impl = ctgr == null ? LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME) :
            ctgr instanceof Class ? LoggerFactory.getLogger(((Class<?>) ctgr).getName()) :
                LoggerFactory.getLogger(ctgr.toString());
        return new StandardLogger(impl);
    }

    @Override
    public void trace(String msg) {
        if (msg == null || msg.trim().length() == 0) {
            return;
        }
        log.trace(msg);
    }

    @Override
    public void debug(String msg) {
        if (msg == null || msg.trim().length() == 0) {
            return;
        }
        log.debug(msg);
    }

    @Override
    public void info(String msg) {
        if (msg == null || msg.trim().length() == 0) {
            return;
        }
        log.info(msg);
    }

    @Override
    public void warning(String msg, @Nullable Throwable e) {
        log.warn(msg, e);
    }

    @Override
    public void error(String msg, @Nullable Throwable e) {
        log.error(msg, e);
    }

    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public boolean isQuiet() {
        return false;
    }

    @Override
    public String fileName() {
        return null;
    }
}
