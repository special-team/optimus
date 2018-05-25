package com.github.ooknight.rubik.support.ebean;

import io.ebean.config.EncryptKey;
import io.ebean.config.Encryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DefaultEncryptor implements Encryptor {

    @Override
    public byte[] encrypt(byte[] data, EncryptKey key) {
        StandardPBEByteEncryptor byteEncryptor = new StandardPBEByteEncryptor();
        byteEncryptor.setPassword(key.getStringValue());
        return byteEncryptor.encrypt(data);
    }

    @Override
    public byte[] decrypt(byte[] data, EncryptKey key) {
        StandardPBEByteEncryptor byteEncryptor = new StandardPBEByteEncryptor();
        byteEncryptor.setPassword(key.getStringValue());
        return byteEncryptor.decrypt(data);
    }

    @Override
    public byte[] encryptString(String formattedValue, EncryptKey key) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key.getStringValue());
        return encryptor.encrypt(formattedValue).getBytes();
    }

    @Override
    public String decryptString(byte[] data, EncryptKey key) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key.getStringValue());
        return encryptor.decrypt(new String(data));
    }
}
