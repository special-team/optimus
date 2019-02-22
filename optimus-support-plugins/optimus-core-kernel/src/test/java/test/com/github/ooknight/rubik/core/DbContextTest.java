package test.com.github.ooknight.rubik.core;

import optimus.JUNIT;
import com.github.ooknight.rubik.optimus.kernel.KernelConfiguration;
import com.github.ooknight.rubik.support.mocker.Mock;

import assist.sample.entity.Sample;
import assist.sample.entity.query.QSample;
import io.ebean.Database;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KernelConfiguration.class)
@ActiveProfiles(JUNIT.PROFILE_DEVELOP)
public class DbContextTest {

    @Resource
    private Database db;

    @Test
    public void testInsert() {
        Sample s = Mock.mock(Sample.class);
        db.insert(s);
        Assert.assertNotNull(s.getId());
    }

    @Test
    public void testUpdate() {
        Sample s = Mock.mock(Sample.class);
        s.setId(2L);
        db.update(s);
        db.update(Sample.class).set("mail", "uuuu").where().idEq(2L).update();
    }

    @Test
    public void testSelect() {
        //System.out.println(db.select(Sample.class));
        //System.out.println(db.select(Sample.class, Scope.DUMMY()));
        //System.out.println(db.select(Sample.class, Scope.DUMMY(), 1, 1).getList());
        //System.out.println(db.select(Sample.class, Scope.DUMMY(), 1, 1).getTotalCount());
        //System.out.println(db.getone(Sample.class, 1L));
        //System.out.println(db.getone(Sample.class, 1L, Scope.DUMMY()));
    }

    @Test
    public void testQuery() {
        //System.out.println(db.createQuery(Sample.class).findList());
        //System.out.println(db.createQuery(Sample.class, Scope.DUMMY()).findList());
    }

    @Test
    public void testQueryWithNull() {
        //System.out.println(db.createQuery(Sample.class).where().eq("mail", null).findList());
        //System.out.println(db.createQuery(Sample.class).where().eq("mail", "uuuu").findList());
        //System.out.println(db.createQuery(Sample.class).where().isNull("mail").findList());
        System.out.println(new QSample().mail.equalTo(null).findList());
        System.out.println(new QSample().mail.isNull().findList());
    }

    @Test
    public void testDelete() {
        db.delete(Sample.class, 3L);
    }
}
