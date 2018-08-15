package com.github.ooknight.rubik.support.ebean;

import io.ebean.config.EncryptKey;
import io.ebean.config.Encryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;

public class DefaultEncryptor implements Encryptor {

    @Override
    public byte[] encrypt(byte[] data, EncryptKey key) {
        if (data == null) {
            return null;
        }
        StandardPBEByteEncryptor encryptor = new StandardPBEByteEncryptor();
        encryptor.setPassword(key.getStringValue());
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        return encryptor.encrypt(data);
    }

    @Override
    public byte[] decrypt(byte[] data, EncryptKey key) {
        if (data == null) {
            return null;
        }
        StandardPBEByteEncryptor encryptor = new StandardPBEByteEncryptor();
        encryptor.setPassword(key.getStringValue());
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        return encryptor.decrypt(data);
    }

    @Override
    public byte[] encryptString(String formattedValue, EncryptKey key) {
        if (formattedValue == null) {
            return null;
        }
        StandardPBEByteEncryptor encryptor = new StandardPBEByteEncryptor();
        encryptor.setPassword(key.getStringValue());
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        return encryptor.encrypt(formattedValue.getBytes());
    }

    @Override
    public String decryptString(byte[] data, EncryptKey key) {
        if (data == null) {
            return null;
        }
        StandardPBEByteEncryptor encryptor = new StandardPBEByteEncryptor();
        encryptor.setPassword(key.getStringValue());
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        return new String(encryptor.decrypt(data));
    }
}
