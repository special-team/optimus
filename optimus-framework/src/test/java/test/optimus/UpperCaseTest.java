package test.optimus;

import optimus.TOOLKIT;

import org.junit.Test;

public class UpperCaseTest {

    @Test
    public void dateFormat() {
        System.out.println(TOOLKIT.DATE_FORMATTER);
    }

    @Test
    public void dateTimeFormat() {
        System.out.println(TOOLKIT.DATE_TIME_FORMATTER);
    }

    @Test
    public void timeFormat() {
        System.out.println(TOOLKIT.TIME_FORMATTER);
    }

    @Test
    public void now() {
        System.out.println(TOOLKIT.NOW());
    }

    @Test
    public void currentDate() {
        System.out.println(TOOLKIT.CURRENT_DATE());
    }

    @Test
    public void currentTime() {
        System.out.println(TOOLKIT.CURRENT_TIME());
    }

    @Test
    public void currentDateTime() {
        System.out.println(TOOLKIT.CURRENT_DATE_TIME());
    }

    @Test
    public void toJsonString() {
        System.out.println(TOOLKIT.TO_JSON_STRING(1));
    }

    @Test
    public void message() {
        System.out.println(TOOLKIT.MESSAGE("the numbers is %s, %s, %s", 1, 2, 3));
    }
}
