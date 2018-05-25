package com.github.ooknight.rubik.support.ebean;

import io.ebean.config.EncryptKey;

public class DefaultEncryptKey implements EncryptKey {

    private String encryptKey;

    public DefaultEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    @Override
    public String getStringValue() {
        return encryptKey;
    }
}
