package test.com.github.ooknight.rubik.core.session;

import com.github.ooknight.rubik.core.session.Scope;

import org.junit.Test;

public class ScopeTest {

    @Test
    public void test() {
        System.out.println(Scope.BUILD(1L, 1L, 1L, true));
        System.out.println(Scope.BUILD(1L, 1L, 1L, false));
        Scope scope = Scope.DUMMY();
        System.out.println(scope.uid());
        System.out.println(scope.rid());
        System.out.println(scope.gid());
        System.out.println(scope.restricteds());
        System.out.println(scope.expressions());
    }
}
