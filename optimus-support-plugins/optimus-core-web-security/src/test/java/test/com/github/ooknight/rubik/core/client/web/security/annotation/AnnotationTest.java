package test.com.github.ooknight.rubik.core.client.web.security.annotation;

import com.github.ooknight.rubik.core.client.web.security.annotation.S;
import com.github.ooknight.rubik.core.client.web.security.annotation.U;

import org.junit.Test;

public class AnnotationTest {

    @Test
    public void test() {
        new X().test(Math.random(), Math.random());
    }

    class X {

        void test(@S Object user, @U Object scope) {
            System.out.println(user);
            System.out.println(scope);
        }
    }
}
