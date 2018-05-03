package test.com.github.ooknight.rubik.core.client.web.security.access;

import com.github.ooknight.rubik.core.client.web.security.access.Permission;

import org.junit.Test;

public class PermissionTest {

    @Test
    public void test() {
        System.out.println(Permission.READ);
        System.out.println(Permission.WRITE);
        System.out.println(Permission.DELETE);
    }
}
