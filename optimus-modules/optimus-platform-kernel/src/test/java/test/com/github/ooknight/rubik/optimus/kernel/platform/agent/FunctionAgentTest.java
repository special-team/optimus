package test.com.github.ooknight.rubik.optimus.kernel.platform.agent;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;
import com.github.ooknight.rubik.optimus.kernel.KernelConfiguration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:develop.properties")
@SpringBootTest(classes = KernelConfiguration.class)
public class FunctionAgentTest {

    @Resource
    private PlatformService agent;

    @Test
    public void menu() {
        List<Module> r1 = agent.menu();
        System.out.println(r1);
        Assert.assertFalse(r1.isEmpty());
    }
}
