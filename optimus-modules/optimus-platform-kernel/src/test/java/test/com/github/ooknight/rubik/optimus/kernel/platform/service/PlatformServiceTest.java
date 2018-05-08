package test.com.github.ooknight.rubik.optimus.kernel.platform.service;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;
import com.github.ooknight.rubik.optimus.kernel.platform.PlatformAutoConfiguration;
import com.github.ooknight.rubik.support.mocker.Mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-develop.properties")
@SpringBootTest(classes = PlatformAutoConfiguration.class)
@EnableAutoConfiguration
public class PlatformServiceTest {

    @Resource
    private PlatformService service;

    @Test
    public void createGroup() {
        Group t = Mock.mock(Group.class);
        System.out.println(t);
        service.create(t);
    }

    @Test
    public void updateGroup() {
        Group t1 = new Group();
        t1.setId(1L);
        t1.setName("测试U1");
        service.update(t1);
        //
        Group t2 = new Group();
        t2.setName("测试U1");
        service.update(t2);
    }

    @Test
    public void getoneGroup() {
        Optional<Group> r1 = service.group(1L);
        Assert.assertTrue(r1.isPresent());
    }

    @Test
    public void browseGroup() {
        List<Group> r1 = service.group();
        Assert.assertFalse(r1.isEmpty());
        List<Group> r2 = service.createGroupQuery().id.in(10L, 20L, 30L).findList();
        Assert.assertFalse(r2.isEmpty());
    }

    @Test
    public void createRole() {
        Role t = Mock.mock(Role.class);
        service.create(t);
    }

    @Test
    public void updateRole() {
        Role t1 = new Role();
        t1.setId(1L);
        t1.setName("测试U1");
        service.update(t1);
        //
        Role t2 = new Role();
        t2.setName("测试U2");
        service.update(t2);
    }

    @Test
    public void getoneRole() {
        Optional<Role> r1 = service.role(1L);
        Assert.assertTrue(r1.isPresent());
    }

    @Test
    public void browseRole() {
        List<Role> r1 = service.role();
        Assert.assertFalse(r1.isEmpty());
        List<Role> r2 = service.createRoleQuery().id.in(10L, 20L, 30L).findList();
        Assert.assertFalse(r2.isEmpty());
    }

    @Test
    public void menu() {
        List<Module> menu = service.menu();
        Assert.assertFalse(menu.isEmpty());
    }

    @Test
    public void shortcut() {
        List<Function> shortcut = service.shortcut();
        Assert.assertTrue(shortcut.isEmpty());
    }

    @Test
    public void changeAccountPassword() {
        service.changeAccountPassword(1L, "");
    }
}
