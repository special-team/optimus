package test.optimus;

import com.github.ooknight.rubik.prototype.authority.Menu;
import com.github.ooknight.rubik.prototype.authority.Scope;

import org.junit.Test;

public class Scattered {

    @Test
    public void testMenu() {
        System.out.println(new Menu("demo:create", "demo-create"));
        System.out.println(new Menu("demo:create", "demo-create", "/demo/create", "demo-icon"));
    }

    @Test
    public void testScope() {
        System.out.println(Scope.BUILD(1L, 1L, 1L, true));
        System.out.println(Scope.BUILD(1L, 1L, 1L, false));
        System.out.println(Scope.DUMMY());
    }
}
