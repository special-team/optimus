package test.com.github.ooknight.rubik.core;

import assist.sample.entity.Sample;
import assist.sample.entity.query.QSample;

import com.github.ooknight.rubik.core.kernel.DBContext;
import com.github.ooknight.rubik.core.session.Scope;
import com.github.ooknight.rubik.optimus.kernel.KernelAutoConfiguration;
import com.github.ooknight.rubik.support.mocker.Mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KernelAutoConfiguration.class)
@ActiveProfiles("develop")
public class DbContextTest {

    @Resource
    private DBContext db;

    @Test
    public void testInsert() {
        Sample s = Mock.mock(Sample.class);
        db.insert(s);
        Assert.assertNotNull(s.getId());
    }

    @Test
    public void testUpdate() {
        Sample s = Mock.mock(Sample.class);
        s.setId(1L);
        db.update(s);
        db.update(Sample.class).set("mail", "uuuu").where().idEq(1L).update();
    }

    @Test
    public void testSelect() {
        System.out.println(db.select(Sample.class));
        System.out.println(db.select(Sample.class, Scope.DUMMY()));
        System.out.println(db.select(Sample.class, Scope.DUMMY(), 1, 1).getList());
        System.out.println(db.select(Sample.class, Scope.DUMMY(), 1, 1).getTotalCount());
        System.out.println(db.getone(Sample.class, 1L));
        System.out.println(db.getone(Sample.class, 1L, Scope.DUMMY()));
    }

    @Test
    public void testQuery() {
        System.out.println(db.createQuery(Sample.class).findList());
        System.out.println(db.createQuery(Sample.class, Scope.DUMMY()).findList());
        System.out.println(db.createQuery(QSample.class).id.eq(1).findList());
        System.out.println(db.createQuery(QSample.class, Scope.DUMMY()).id.eq(1).findList());
    }

    @Test
    public void testDelete() {
        db.delete(Sample.class, 1L);
    }
}
