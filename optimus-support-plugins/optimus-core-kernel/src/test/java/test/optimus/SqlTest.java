package test.optimus;

import optimus.SQL;

import org.junit.Test;

public class SqlTest {

    @Test
    public void test() {
        System.out.println(SQL.NOW());
        System.out.println(SQL.CURRENT_DATE());
        //noinspection ConstantConditions
        System.out.println(SQL.NOT_NULL(1));
    }
}
