package test.com.github.ooknight.rubik.support.core.exception;

import com.github.ooknight.rubik.support.core.exception.BusinessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BusinessExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage(BusinessException.PREFIX + "test-error");
        throw new BusinessException("test-error");
    }

    @Test
    public void test2() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage(BusinessException.PREFIX + "test-error");
        throw new BusinessException("test-error", new NullPointerException("this is null"));
    }
}
