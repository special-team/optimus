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
        throw new BusinessException(BusinessException.Type.ENTITY_NOT_FOUND);
    }

    @Test
    public void test2() {
        thrown.expect(BusinessException.class);
        throw new BusinessException(BusinessException.Type.UNAUTHORIZED_ACCESS);
    }

    @Test
    public void test3() {
        thrown.expect(BusinessException.class);
        throw new BusinessException(BusinessException.Type.ENTITY_NOT_FOUND, new NullPointerException("this is null"));
    }

    @Test
    public void test4() {
        thrown.expect(BusinessException.class);
        throw new BusinessException(BusinessException.Type.UNAUTHORIZED_ACCESS, new NullPointerException("this is null"));
    }
}
