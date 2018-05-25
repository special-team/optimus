package test.com.github.ooknight.rubik.support.ebean;

import com.github.ooknight.rubik.support.ebean.DefaultEncryptKey;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptor;

import io.ebean.config.EncryptKey;
import org.junit.Test;

public class DefaultEncryptorTest {

    private static final EncryptKey KEY = new DefaultEncryptKey("123456");

    @Test
    public void test1() {
        String plain = "123456";
        DefaultEncryptor encryptor = new DefaultEncryptor();
        byte[] byte1 = encryptor.encryptString(plain, KEY);
        String dencrypted = encryptor.decryptString(byte1, KEY);
        System.out.println(dencrypted);
    }

    @Test
    public void test2() {
        byte[] plain = "123456".getBytes();
        DefaultEncryptor encryptor = new DefaultEncryptor();
        byte[] byte1 = encryptor.encrypt(plain, KEY);
        byte[] dencrypted = encryptor.decrypt(byte1, KEY);
        System.out.println(new String(dencrypted));
    }
}
