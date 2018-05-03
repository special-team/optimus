package test.optimus;

import optimus.TOOLKIT;

import org.junit.Test;

public class ToolkitTest {

    @Test
    public void dateFormat() {
        System.out.println(TOOLKIT.DATE_FROMAT);
    }

    @Test
    public void dateTimeFormat() {
        System.out.println(TOOLKIT.DATE_TIME_FROMAT);
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
}
