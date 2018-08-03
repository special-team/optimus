package test.com.github.ooknight.rubik.support.ebean;

import com.github.ooknight.rubik.support.ebean.DefaultEncryptKeyManager;

import io.ebean.config.EncryptKeyManager;
import org.junit.Test;

public class DefaultEncryptKeyManagerTest {

    @Test
    public void test() {
        EncryptKeyManager encryptKeyManager = new DefaultEncryptKeyManager();
        System.out.println(encryptKeyManager);
    }
}
