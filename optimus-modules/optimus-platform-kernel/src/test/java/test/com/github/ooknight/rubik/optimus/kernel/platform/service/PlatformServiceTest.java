package test.com.github.ooknight.rubik.optimus.kernel.platform.service;

import optimus.JUNIT;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Setting;
import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;
import com.github.ooknight.rubik.optimus.kernel.platform.PlatformAutoConfiguration;
import com.github.ooknight.rubik.support.mocker.Mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlatformAutoConfiguration.class)
@ActiveProfiles(JUNIT.SPRING_PROFILE)
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
    }

    @Test
    public void menu() {
        List<Module> menu = service.menu();
        Assert.assertFalse(menu.isEmpty());
        menu.forEach(module -> {
            System.out.println(module.getName());
            module.getFunction().forEach(function -> System.out.println(">>>> " + function.getName()));
        });
    }

    @Test
    public void shortcut() {
        List<Function> shortcut = service.shortcut();
        Assert.assertTrue(shortcut.isEmpty());
        System.out.println(shortcut);
    }

    @Test
    public void settingGet() {
        System.out.println("========= ========= ========= ========= ========= ========= ========= ========= ========= first fetch");
        String r = service.setting(Setting.KEY.ACCOUNT_DEFAULT_PASSWORD);
        System.out.println(r);
        System.out.println("========= ========= ========= ========= ========= ========= ========= ========= ========= second fetch");
        String r2 = service.setting(Setting.KEY.ACCOUNT_DEFAULT_PASSWORD);
        System.out.println(r2);
        System.out.println("========= ========= ========= ========= ========= ========= ========= ========= ========= put");
        service.setting(Setting.KEY.ACCOUNT_DEFAULT_PASSWORD, "654321");
        System.out.println("========= ========= ========= ========= ========= ========= ========= ========= ========= after put fetch");
        String r3 = service.setting(Setting.KEY.ACCOUNT_DEFAULT_PASSWORD);
        System.out.println(r3);
    }

    @Test
    public void changeAccountPassword() {
        service.changeAccountPassword(1L, "");
    }
}
