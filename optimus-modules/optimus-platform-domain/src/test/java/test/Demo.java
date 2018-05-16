package test;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Message;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Privilege;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Setting;
import com.github.ooknight.rubik.optimus.archer.platform.enums.DisplayMode;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.avaje.datasource.DataSourceConfig;
import org.junit.Before;
import org.junit.Test;

public class Demo {

    private EbeanServer db;

    @Before
    public void before() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver("org.h2.Driver");
        //dsc.setUrl("jdbc:h2:mem:demo_db;INIT=RUNSCRIPT FROM 'classpath:/db-schema.ddl'\\;RUNSCRIPT FROM 'classpath:/db-datum.ddl'");
        dsc.setUrl("jdbc:h2:mem:demo_db;INIT=RUNSCRIPT FROM 'classpath:/db-schema.ddl';");
        dsc.setUsername("sa");
        dsc.setPassword("sa");
        //
        ServerConfig sc = new ServerConfig();
        sc.setDataSourceConfig(dsc);
        sc.setDatabaseBooleanTrue("1");
        sc.setDatabaseBooleanFalse("0");
        sc.setAutoCommitMode(true);
        sc.setDefaultServer(true);
        sc.setRegister(true);
        //
        db = EbeanServerFactory.create(sc);
    }

    @Test
    public void test() {
        System.out.println(db.find(Account.class).findList().size());
        System.out.println(db.find(Function.class).findList().size());
        System.out.println(db.find(Group.class).findList().size());
        System.out.println(db.find(Message.class).findList().size());
        System.out.println(db.find(Module.class).findList().size());
        System.out.println(db.find(Privilege.class).findList().size());
        System.out.println(db.find(Role.class).findList().size());
        System.out.println(db.find(Setting.class).findList().size());
    }

    @Test
    public void test1() {
        System.out.println(DisplayMode.NONE);
        System.out.println(DisplayMode.MENU);
        System.out.println(DisplayMode.SHORTCUT);
        System.out.println(DisplayMode.MENU_AND_SHORTCUT);
    }

    @Test
    public void test2() {
        Setting setting = new Setting();
        setting.setConfigKey(Setting.KEY.ACCOUNT_DEFAULT_PASSWORD);
        setting.setConfigValue("123456");
        System.out.println(setting);
        db.insert(setting);
        System.out.println(db.createQuery(Setting.class).findList());
    }
}
