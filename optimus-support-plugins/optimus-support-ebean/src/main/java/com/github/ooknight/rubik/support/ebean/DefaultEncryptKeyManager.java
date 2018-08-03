package com.github.ooknight.rubik.support.ebean;

import io.ebean.config.EncryptKey;
import io.ebean.config.EncryptKeyManager;

import java.util.HashMap;
import java.util.Map;

public class DefaultEncryptKeyManager implements EncryptKeyManager {

    private EncryptKey encryptKeyDefault = new DefaultEncryptKey("0123456789");
    private Map<String, EncryptKey> encryptKeyMap = new HashMap<>();

    @Override
    public EncryptKey getEncryptKey(String table, String column) {
        return encryptKeyMap.getOrDefault(table + "." + column, encryptKeyDefault);
    }

    @Override
    public void initialise() {
    }

    public void put(String table, String column, String key) {
        this.encryptKeyMap.put(table + "." + column, new DefaultEncryptKey(key));
    }

    public void put(Map<String, EncryptKey> maps) {
        this.encryptKeyMap.putAll(maps);
    }
}
