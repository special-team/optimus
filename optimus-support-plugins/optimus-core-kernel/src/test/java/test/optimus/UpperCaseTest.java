package test.optimus;

import optimus.KERNEL;
import optimus.SQL;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UpperCaseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1() {
        thrown.expect(BusinessException.class);
        throw KERNEL.ERROR(BusinessException.Type.ENTITY_NOT_FOUND);
    }

    @Test
    public void test2() {
        thrown.expect(RuntimeException.class);
        KERNEL.PROPAGATE(new ClassNotFoundException());
    }

    @Test
    public void test3() {
        System.out.println(SQL.NOW());
        System.out.println(SQL.CURRENT_DATE());
        //noinspection ConstantConditions
        System.out.println(SQL.NOT_NULL(1));
    }
}
