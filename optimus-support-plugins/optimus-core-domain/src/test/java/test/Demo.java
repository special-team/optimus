package test;

import com.github.ooknight.rubik.core.entity.Active;
import com.github.ooknight.rubik.core.session.AccountType;

import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.annotation.EnumValue;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import test.sample.entity.Sample;
import test.sample.entity.query.QSample;

import java.util.List;

public class Demo {

    @Test
    public void testActive() {
        System.out.println(Active.ENABLED.code());
        System.out.println(Active.DISABLED.code());
        System.out.println(Active.LOCKED.code());
    }

    @Test
    public void testAccountType() throws NoSuchFieldException {
        System.out.println(AccountType.NORMAL);
        System.out.println(AccountType.ADMIN);
        System.out.println(AccountType.GOD);
        Assert.assertEquals("1", AnnotationUtils.getAnnotation(AccountType.class.getDeclaredField("NORMAL"), EnumValue.class).value());
        Assert.assertEquals("8", AnnotationUtils.getAnnotation(AccountType.class.getDeclaredField("ADMIN"), EnumValue.class).value());
        Assert.assertEquals("9", AnnotationUtils.getAnnotation(AccountType.class.getDeclaredField("GOD"), EnumValue.class).value());
    }

    @Test
    public void test0() {
        Sample s1 = new Sample();
        Assert.assertEquals(1, s1.active().code());
        Assert.assertEquals(Active.ENABLED, s1.active());
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
}
