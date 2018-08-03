package test.optimus;

import com.google.common.base.Stopwatch;
import io.ebean.annotation.EnumValue;
import io.ebean.util.AnnotationUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class Performance {

    @Test
    public void test() {
        int count = 10000000;
        Stopwatch stopwatch = Stopwatch.createStarted();
        //
        for (int i = 0; i < count; i++) {
            Assert.assertEquals("1", SampleState1.YES.code());
            Assert.assertEquals("2", SampleState1.NO.code());
        }
        long t1 = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        //
        stopwatch.reset().start();
        for (int i = 0; i < count; i++) {
            Assert.assertEquals("1", SampleState2.YES.code());
            Assert.assertEquals("2", SampleState2.NO.code());
        }
        long t2 = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        //
        stopwatch.reset().start();
        for (int i = 0; i < count; i++) {
            Assert.assertEquals("1", SampleState3.YES.code());
            Assert.assertEquals("2", SampleState3.NO.code());
        }
        long t3 = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        //
        System.out.println("T1: " + t1);
        System.out.println("T2: " + t2);
        System.out.println("T3: " + t3);
    }

    enum SampleState1 implements A {
        @EnumValue("1") YES,
        @EnumValue("2") NO,
    }

    enum SampleState2 implements B {
        @EnumValue("1") YES,
        @EnumValue("2") NO,
    }

    enum SampleState3 {
        //
        YES("1"), NO("2");
        //
        private String code;

        SampleState3(String code) {
            this.code = code;
        }

        public String code() {
            return this.code;
        }
    }

    interface A {

        default String code() {
            try {
                String name = ((Enum) this).name();
                EnumValue value = AnnotationUtil.findAnnotation(this.getClass().getDeclaredField(name), EnumValue.class);
                return value.value();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    interface B {

        ConcurrentMap<String, String> store = new ConcurrentHashMap<>();

        default String code() {
            try {
                String cls = ((Enum) this).getDeclaringClass().getSimpleName();
                String name = ((Enum) this).name();
                String r = store.get(cls + "." + name);
                if (r == null) {
                    EnumValue value = AnnotationUtil.findAnnotation(this.getClass().getDeclaredField(name), EnumValue.class);
                    r = value.value();
                    store.put(cls + "." + name, r);
                }
                return r;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
