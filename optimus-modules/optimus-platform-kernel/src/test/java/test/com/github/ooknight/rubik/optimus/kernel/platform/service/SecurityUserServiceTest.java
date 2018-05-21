package test.com.github.ooknight.rubik.optimus.kernel.platform.service;

import optimus.JUNIT;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;
import com.github.ooknight.rubik.optimus.kernel.platform.PlatformAutoConfiguration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlatformAutoConfiguration.class)
@ActiveProfiles(JUNIT.SPRING_PROFILE)
public class SecurityUserServiceTest {

    @Resource
    private SecurityUserService service;

    @Test
    public void getAccount() {
        Optional<Account> a1 = service.getAccount("admin");
        Assert.assertTrue(a1.isPresent());
        //
        Optional<Account> a2 = service.getAccount("god");
        Assert.assertTrue(a2.isPresent());
        //
        Optional<Account> a3 = service.getAccount("notexist");
        Assert.assertFalse(a3.isPresent());
        //
        Optional<Account> a4 = service.getAccount(null);
        Assert.assertFalse(a4.isPresent());
    }

    @Test
    public void getResource() {
        Set<String> r1 = service.getResource(1L, 1L);
        Assert.assertTrue(r1.isEmpty());
        Set<String> r2 = service.getResource(10L, 1011L);
        Assert.assertFalse(r2.isEmpty());
        Assert.assertEquals(3, r2.size());
    }

    @Test
    public void getResourceForAdministrator() {
        Set<String> r = service.getResourceForSupervisor();
        Assert.assertFalse(r.isEmpty());
    }

    @Test
    public void getPrivilege() {
        System.out.println("========= role X ========= group X");
        System.out.println(service.getPrivilege(null, null));
        System.out.println("========= role X ========= group O");
        System.out.println(service.getPrivilege(null, 1L));
        System.out.println("========= role O ========= group X");
        System.out.println(service.getPrivilege(1L, null));
        System.out.println("========= role O ========= group O");
        System.out.println(service.getPrivilege(1L, 1L));
    }
}
