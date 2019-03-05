package test.optimus;

import com.github.ooknight.rubik.core.entity.Active;

import assist.sample.entity.Sample;
import assist.sample.entity.query.QSample;
import io.ebean.Ebean;
import io.ebean.Query;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class Scattered {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testActive() {
        Assert.assertEquals(1, Active.ENABLED.code());
        Assert.assertEquals(0, Active.LOCKED.code());
        Assert.assertEquals(-1, Active.DISABLED.code());
    }

    @Test
    public void testNewEntity() {
        Sample s1 = new Sample();
        Assert.assertEquals(Active.ENABLED, s1.active());
        Assert.assertEquals(1, s1.active().code());
    }

    @Test
    public void testInsert() {
        Sample sample = new Sample();
        Ebean.insert(sample);
    }

    @Test
    public void testDelete() {
        Ebean.delete(Sample.class, 1L);
        Ebean.deletePermanent(Sample.class, 1L);
        Ebean.delete(new Sample());
        Ebean.deletePermanent(new Sample());
    }

    @Test
    public void testUpdate() {
        Sample sample = new Sample();
        sample.setName("test");
        sample.setMail("hello");
        Ebean.save(sample);
        sample.setMail("hello@163.com");
        Ebean.update(sample);
        //
        //Ebean.update(Sample.class).set("name", "hello2").where().idEq(1).update();
        //
        Ebean.find(Sample.class).findList().forEach(System.out::println);
        Ebean.createSqlQuery("select * from e_sample").findList().forEach(System.out::println);
        //
        //Ebean.update(Sample.class).set(Sample.FIELD_MAIL, "hello").where().eq(Sample.FIELD_NAME, "sample1").update();
        //System.out.println(Ebean.find(Sample.class, 1));
    }

    @Test
    public void testQuery() {
        Ebean.createQuery(Sample.class).findList();
    }

    @Test
    public void test1() {
        Query<Sample> query = Ebean.createQuery(Sample.class);
        List<Sample> r1 = query.findList();
        Assert.assertEquals(2, r1.size());
        List<Sample> r2 = query.setIncludeSoftDeletes().findList();
        Assert.assertEquals(3, r2.size());
        Assert.assertEquals(Active.ENABLED, r2.get(0).active());
        Assert.assertEquals(Active.ENABLED, r2.get(1).active());
        Assert.assertEquals(Active.DISABLED, r2.get(2).active());
    }

    @Test
    public void test2() {
        QSample query = new QSample();
        List<Sample> r1 = query.findList();
        Assert.assertEquals(2, r1.size());
        List<Sample> r2 = query.setIncludeSoftDeletes().findList();
        Assert.assertEquals(3, r2.size());
        Assert.assertEquals(Active.ENABLED, r2.get(0).active());
        Assert.assertEquals(Active.ENABLED, r2.get(1).active());
        Assert.assertEquals(Active.DISABLED, r2.get(2).active());
        Sample sample = query.id.eq(1).findOne();
        Assert.assertNotNull(sample);
        System.out.println(sample);
    }

    @Test
    public void test3() {
        List<Sample> r1 = new QSample().id.eq(1).findList();
        System.out.println(r1);
    }

    @Test
    public void test4() {
        //System.out.println(QueryEngine.SELECT(Sample.class, 1L));
        //System.out.println(QueryEngine.SELECT(Sample.class, Scope.DUMMY(), 1L));
        //System.out.println(QueryEngine.SELECT(Sample.class));
        //System.out.println(QueryEngine.SELECT(Sample.class, Scope.DUMMY()));
    }

    @Test
    public void test5() {
        //System.out.println(QueryEngine.GETONE(Sample.class, 1L));
        //thrown.expect(BusinessException.class);
        //System.out.println(QueryEngine.GETONE(Sample.class, Scope.DUMMY(), 1L));
    }

    @Test
    public void test6() {
        Sample sample = new Sample();
        sample.setName("test");
        sample.setMail("test@test.com");
        Ebean.insert(sample);
        System.out.println(Ebean.createSqlQuery("select * from e_sample where name_='test'").findOne());
        List<Sample> s1 = Ebean.createQuery(Sample.class).where().eq("mail", "test@test.com").findList();
        Assert.assertEquals(1, s1.size());
        List<Sample> s2 = new QSample().mail.equalTo("test@test.com").findList();
        Assert.assertEquals(1, s2.size());
    }
}
