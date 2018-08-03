package test.com.github.ooknight.rubik.support.ebean;

import com.github.ooknight.rubik.support.ebean.DefaultEncryptKey;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptor;

import io.ebean.config.EncryptKey;
import org.junit.Assert;
import org.junit.Test;

public class DefaultEncryptorTest {

    private static final EncryptKey KEY = new DefaultEncryptKey("123456");

    @Test
    public void test1() {
        String plain = "123456";
        DefaultEncryptor encryptor = new DefaultEncryptor();
        byte[] byte1 = encryptor.encryptString(plain, KEY);
        String decrypted = encryptor.decryptString(byte1, KEY);
        Assert.assertEquals("error", plain, decrypted);
    }

    @Test
    public void test2() {
        byte[] plain = "123456".getBytes();
        DefaultEncryptor encryptor = new DefaultEncryptor();
        byte[] byte1 = encryptor.encrypt(plain, KEY);
        byte[] decrypted = encryptor.decrypt(byte1, KEY);
        Assert.assertArrayEquals("error", plain, decrypted);
    }

    @Test
    public void test3() {
        DefaultEncryptor encryptor = new DefaultEncryptor();
        byte[] byte1 = encryptor.encryptString(null, KEY);
        String decrypted = encryptor.decryptString(byte1, KEY);
        Assert.assertNull(decrypted);
    }

    @Test
    public void test4() {
        DefaultEncryptor encryptor = new DefaultEncryptor();
        byte[] byte1 = encryptor.encrypt(null, KEY);
        byte[] decrypted = encryptor.decrypt(byte1, KEY);
        Assert.assertNull(decrypted);
    }
}
