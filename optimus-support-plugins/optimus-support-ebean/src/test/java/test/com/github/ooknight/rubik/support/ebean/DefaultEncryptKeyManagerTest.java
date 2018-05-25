package test.com.github.ooknight.rubik.support.ebean;

import com.github.ooknight.rubik.support.ebean.DefaultEncryptKey;
import com.github.ooknight.rubik.support.ebean.DefaultEncryptKeyManager;

import io.ebean.config.EncryptKeyManager;
import org.junit.Test;

import java.util.HashMap;

public class DefaultEncryptKeyManagerTest {

    @Test
    public void test() {
        EncryptKeyManager encryptKeyManager = new DefaultEncryptKeyManager(new DefaultEncryptKey("123456"), new HashMap<>());
        System.out.println(encryptKeyManager);
    }
}
