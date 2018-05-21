package test.optimus;

import assist.sample.entity.Sample;
import assist.sample.entity.query.QSample;

import com.github.ooknight.rubik.core.entity.Active;
import com.github.ooknight.rubik.core.query.QueryEngine;
import com.github.ooknight.rubik.core.session.AccountType;
import com.github.ooknight.rubik.core.session.Menu;
import com.github.ooknight.rubik.core.session.Scope;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.annotation.EnumValue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.List;
import java.util.Optional;

public class Scattered {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Ignore
    public void testMenu() {
        System.out.println(new Menu("demo:create", "demo-create"));
        System.out.println(new Menu("demo:create", "demo-create", "/demo/create", "demo-icon"));
    }

    @Test
    @Ignore
    public void testScope() {
        System.out.println(Scope.BUILD(1L, 1L, 1L, true));
        System.out.println(Scope.BUILD(1L, 1L, 1L, false));
        Scope scope = Scope.DUMMY();
        System.out.println(scope.uid());
        System.out.println(scope.rid());
        System.out.println(scope.gid());
        System.out.println(scope.restricteds());
        System.out.println(scope.expressions());
    }

    @Test
    public void testActive() {
        Assert.assertEquals(1, Active.ENABLED.code());
        Assert.assertEquals(0, Active.LOCKED.code());
        Assert.assertEquals(-1, Active.DISABLED.code());
    }

    @Test
    public void testAccountType() throws NoSuchFieldException {
        System.out.println(AccountType.GOD);
        System.out.println(AccountType.ADMIN);
        System.out.println(AccountType.NORMAL);
        Assert.assertEquals("1", AnnotationUtils.getAnnotation(AccountType.class.getDeclaredField("GOD"), EnumValue.class).value());
        Assert.assertEquals("10", AnnotationUtils.getAnnotation(AccountType.class.getDeclaredField("ADMIN"), EnumValue.class).value());
        Assert.assertEquals("11", AnnotationUtils.getAnnotation(AccountType.class.getDeclaredField("NORMAL"), EnumValue.class).value());
    }

    @Test
    public void test0() {
        Sample s1 = new Sample();
        Assert.assertEquals(Active.ENABLED, s1.active());
        Assert.assertEquals(1, s1.active().code());
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
        List<Sample> r1 = QueryEngine.QUERY(QSample.class).id.eq(1).findList();
        System.out.println(r1);
        List<Sample> r2 = QueryEngine.QUERY(QSample.class, Scope.DUMMY()).id.eq(1).findList();
        System.out.println(r2);
    }

    @Test
    public void test4() {
        Optional<Sample> r1 = QueryEngine.SELECT(Sample.class, 1L);
        System.out.println(r1);
        Sample r2 = QueryEngine.GETONE(Sample.class, 1L);
        System.out.println(r2);
        thrown.expect(BusinessException.class);
        Sample r3 = QueryEngine.GETONE(Sample.class, 999L);
        System.out.println(r3);
    }
}
