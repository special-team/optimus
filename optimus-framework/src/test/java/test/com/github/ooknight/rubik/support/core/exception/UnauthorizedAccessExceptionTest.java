package test.com.github.ooknight.rubik.support.core.exception;

import com.github.ooknight.rubik.support.core.exception.BusinessException;
import com.github.ooknight.rubik.support.core.exception.UnauthorizedAccessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UnauthorizedAccessExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test() {
        thrown.expect(UnauthorizedAccessException.class);
        thrown.expectMessage(BusinessException.PREFIX + "unauthorized-access");
        throw new UnauthorizedAccessException();
    }
}
