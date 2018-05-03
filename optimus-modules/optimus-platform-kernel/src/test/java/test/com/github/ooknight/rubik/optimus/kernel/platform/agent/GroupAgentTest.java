package test.com.github.ooknight.rubik.optimus.kernel.platform.agent;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
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

@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KernelConfiguration.class)
public class GroupAgentTest {

    @Resource
    private PlatformService agent;

    @Test
    public void create() {
        Group t = new Group();
        t.setId(100L);
        t.setName("测试C1");
        t.setType(null);
        agent.create(t);
        Assert.assertEquals(new Long(100L), t.getId());
    }

    @Test
    public void update() {
        Group t1 = new Group();
        t1.setId(1L);
        t1.setName("测试U1");
        t1.setType(null);
        agent.update(t1);
        //
        Group t2 = new Group();
        t2.setName("测试U1");
        t2.setType(null);
        agent.update(t2);
    }

    @Test
    public void getone() {
        Optional<Group> r1 = agent.group(1L);
        Assert.assertTrue(r1.isPresent());
    }

    @Test
    public void browse() {
        List<Group> r1 = agent.group();
        Assert.assertFalse(r1.isEmpty());
    }
}
