package test.com.github.ooknight.rubik.core.session;

import com.github.ooknight.rubik.core.session.Menu;

import org.junit.Test;

public class MenuTest {

    @Test
    public void test1() {
        Menu menu = new Menu("demo:create", "demo-create");
        System.out.println(menu);
    }

    @Test
    public void test2() {
        Menu menu = new Menu("demo:create", "demo-create", "/demo/create", "demo-icon");
        System.out.println(menu);
    }
}
