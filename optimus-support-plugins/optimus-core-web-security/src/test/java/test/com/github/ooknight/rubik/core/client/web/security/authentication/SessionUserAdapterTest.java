package test.com.github.ooknight.rubik.core.client.web.security.authentication;

import com.github.ooknight.rubik.core.client.web.security.authentication.SessionUserAdapter;
import com.github.ooknight.rubik.core.entity.Active;
import com.github.ooknight.rubik.prototype.authority.SessionUser;
import com.github.ooknight.rubik.prototype.authority.SessionUserType;

import org.junit.Test;

public class SessionUserAdapterTest {

    @Test
    public void test() {
        SessionUser su = new SessionUserAdapter(1L, 1L, 1L, "name", "password", SessionUserType.ADMIN, Active.ENABLED);
        System.out.println(su);
        System.out.println((su.scope()));
    }
}
