package test.com.github.ooknight.rubik.optimus.kernel.platform.agent;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;
import com.github.ooknight.rubik.optimus.kernel.KernelConfiguration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KernelConfiguration.class)
public class RoleAgentTest {

    @Resource
    private PlatformService agent;

    @Test
    public void create() {
        Role t = new Role();
        t.setId(100L);
        t.setName("测试C1");
        t.setScopeType(1);
        agent.create(t);
        Assert.assertEquals(new Long(100L), t.getId());
    }

    @Test
    public void update() {
        Role t1 = new Role();
        t1.setId(1L);
        t1.setName("测试U1");
        t1.setScopeType(1);
        agent.update(t1);
        //
        Role t2 = new Role();
        t2.setName("测试U2");
        t2.setScopeType(1);
        agent.update(t2);
    }

    @Test
    public void getone() {
        Optional<Role> r1 = agent.role(1L);
        Assert.assertTrue(r1.isPresent());
    }

    @Test
    public void browse() {
        List<Role> r1 = agent.role();
        Assert.assertFalse(r1.isEmpty());
    }
}

