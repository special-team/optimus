package test.optimus;

import optimus.WEB;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

public class WebTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test0() {
        thrown.expect(WEB.E404.class);
        thrown.expectMessage(BusinessException.PREFIX + "404");
        throw WEB.ERROR_HTTP_404();
    }

    @Test
    public void test1() {
        thrown.expect(WEB.E500.class);
        thrown.expectMessage(BusinessException.PREFIX + "test");
        throw WEB.ERROR("test");
    }

    @Test
    public void test2() {
        System.out.println(WEB.PARAM(1, 0));
        System.out.println(WEB.DATE_LIST(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 3)));
        System.out.println(WEB.DATE_LIST_STRING(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 3)));
    }
}
