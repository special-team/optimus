package test;

import com.github.ooknight.rubik.support.mocker.Mock;

import org.junit.Test;
import test.entity.Hero;

import java.time.LocalDate;

public class Demo {

    @Test
    public void test() {
        Hero hero = Mock.mock(Hero.class);
        System.out.println(hero);
    }

    @Test
    public void test2() throws Exception {
        //long x = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01").getTime();
        //System.out.println(x);
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(0)));
        System.out.println(LocalDate.ofEpochDay(99999));
    }
}
