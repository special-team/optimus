package test;

import com.github.ooknight.rubik.optimus.archer.platform.entity.Account;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Group;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Message;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Privilege;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Role;
import com.github.ooknight.rubik.optimus.archer.platform.enums.DisplayMode;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.avaje.datasource.DataSourceConfig;
import org.junit.Test;

public class Demo {

    @Test
    public void test() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver("org.h2.Driver");
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
        EbeanServer db = EbeanServerFactory.create(sc);
        //
        System.out.println(db.find(Account.class).findList().size());
        System.out.println(db.find(Function.class).findList().size());
        System.out.println(db.find(Group.class).findList().size());
        System.out.println(db.find(Message.class).findList().size());
        System.out.println(db.find(Module.class).findList().size());
        System.out.println(db.find(Privilege.class).findList().size());
        System.out.println(db.find(Role.class).findList().size());
    }

    @Test
    public void test1() {
        System.out.println(DisplayMode.NONE);
        System.out.println(DisplayMode.MENU);
        System.out.println(DisplayMode.SHORTCUT);
        System.out.println(DisplayMode.MENU_AND_SHORTCUT);
    }
}
