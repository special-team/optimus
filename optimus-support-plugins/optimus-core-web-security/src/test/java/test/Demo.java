package test;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class Demo {

    @Test
    public void test() {
        String x = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456");
        System.out.println(x);
    }
}
