package com.github.ooknight.rubik.support.ebean;

import io.ebean.config.EncryptKey;
import io.ebean.config.EncryptKeyManager;

import java.util.Map;

public class DefaultEncryptKeyManager implements EncryptKeyManager {

    private EncryptKey encryptKeyDefault;
    private Map<String, EncryptKey> encryptKeyMap;

    public DefaultEncryptKeyManager(EncryptKey encryptKeyDefault, Map<String, EncryptKey> encryptKeyMap) {
        this.encryptKeyDefault = encryptKeyDefault;
        this.encryptKeyMap = encryptKeyMap;
    }

    @Override
    public EncryptKey getEncryptKey(String tableName, String columnName) {
        return encryptKeyMap.getOrDefault(tableName + "." + columnName, encryptKeyDefault);
    }

    @Override
    public void initialise() {
    }
}
