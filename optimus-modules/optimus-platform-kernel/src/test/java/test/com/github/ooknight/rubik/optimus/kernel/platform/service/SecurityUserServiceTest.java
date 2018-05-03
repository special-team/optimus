package test.com.github.ooknight.rubik.optimus.kernel.platform.service;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Privilege;
import com.github.ooknight.rubik.optimus.archer.platform.service.SecurityUserService;
import com.github.ooknight.rubik.optimus.kernel.KernelConfiguration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:develop.properties")
@SpringBootTest(classes = KernelConfiguration.class)
public class SecurityUserServiceTest {

    @Resource
    private SecurityUserService service;

    @Test
    public void getAccount() {
        Optional<Account> a1 = service.getAccount("admin");
        Assert.assertTrue(a1.isPresent());
        //
        Optional<Account> a2 = service.getAccount("cat");
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
        Set<String> r2 = service.getResource(1L, 2L);
        Assert.assertFalse(r2.isEmpty());
        Assert.assertEquals(3, r2.size());
    }

    @Test
    public void getResourceForAdministrator() {
        Set<String> r = service.getResourceForAdministrator();
        Assert.assertFalse(r.isEmpty());
    }

    @Test
    public void getPrivilege() {
        Set<Privilege> r1 = service.getPrivilege(1L, 1L);
        Assert.assertTrue(r1.isEmpty());
        System.out.println(r1);
    }
}
