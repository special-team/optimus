package test.com.github.ooknight.rubik.support.core.exception;

import com.github.ooknight.rubik.framework.exception.BusinessException;
import com.github.ooknight.rubik.framework.exception.BusinessExceptionType;
import com.github.ooknight.rubik.prime.OClass;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class BusinessExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testOnlyKey1() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("BUSINESS_EXCEPTION.ENTITY_NOT_FOUND:[]");
        throw new BusinessException(BusinessExceptionType.Default.ENTITY_NOT_FOUND);
    }

    @Test
    public void testOnlyKey2() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("BUSINESS_EXCEPTION.UNAUTHORIZED_ACCESS:[]");
        throw new BusinessException(BusinessExceptionType.Default.UNAUTHORIZED_ACCESS);
    }

    @Test
    public void testWithArgs1() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("BUSINESS_EXCEPTION.ENTITY_NOT_FOUND:[class com.github.ooknight.rubik.prime.OClass, 1]");
        throw new BusinessException(BusinessExceptionType.Default.ENTITY_NOT_FOUND, OClass.class, 1);
    }

    @Test
    public void testWithArgs2() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("BUSINESS_EXCEPTION.UNAUTHORIZED_ACCESS:[testuser]");
        throw new BusinessException(BusinessExceptionType.Default.UNAUTHORIZED_ACCESS, "testuser");
    }

    @Test
    public void testWithStack1() {
        thrown.expect(BusinessException.class);
        thrown.expectCause(Matchers.isA(IOException.class));
        throw new BusinessException(BusinessExceptionType.Default.ENTITY_NOT_FOUND, new IOException());
    }

    @Test
    public void testWithStack2() {
        thrown.expect(BusinessException.class);
        thrown.expectCause(Matchers.isA(IOException.class));
        throw new BusinessException(BusinessExceptionType.Default.UNAUTHORIZED_ACCESS, new IOException("this is null"));
    }

    @Test
    public void testWithArgsAndStack1() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("BUSINESS_EXCEPTION.ENTITY_NOT_FOUND:[class com.github.ooknight.rubik.prime.OClass, 1]");
        thrown.expectCause(Matchers.isA(IOException.class));
        throw new BusinessException(BusinessExceptionType.Default.ENTITY_NOT_FOUND, new IOException("this is null"), OClass.class, 1);
    }

    @Test
    public void testWithArgsAndStack2() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("BUSINESS_EXCEPTION.UNAUTHORIZED_ACCESS:[testuser]");
        thrown.expectCause(Matchers.isA(IOException.class));
        throw new BusinessException(BusinessExceptionType.Default.UNAUTHORIZED_ACCESS, new IOException("this is null"), "testuser");
    }

    @Test
    public void testCustomize() {
        thrown.expectMessage("BUSINESS_EXCEPTION.UNKNOWN:[]");
        throw new BusinessException(X.UNKNOWN);
    }

    private enum X implements BusinessExceptionType {
        UNKNOWN
    }
}
