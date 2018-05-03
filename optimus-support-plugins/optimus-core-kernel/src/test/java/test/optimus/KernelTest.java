package test.optimus;

import optimus.KERNEL;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KernelTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1() {
        thrown.expect(BusinessException.class);
        thrown.expectMessage(BusinessException.PREFIX + "test-error");
        throw KERNEL.ERROR("test-error");
    }
}
