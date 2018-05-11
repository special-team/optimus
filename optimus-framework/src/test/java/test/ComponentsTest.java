package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class ComponentsTest {

    @Test
    public void testDateTimeFormt() {
        for (Locale locale : Locale.getAvailableLocales()) {
            String k = locale.toString();
            String v = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale).format(new Date());
            System.out.format("%-30s : %s \n", k, v);
        }
    }

    @Test
    public void testLogger() {
        Logger logger = LoggerFactory.getLogger("test");
        logger.trace("traceeee");
        logger.debug("debugggg");
        logger.info("infooooo");
        logger.warn("warnnnnn");
        logger.error("errorrrr");
    }

    @Test
    public void testWeek() {
        DayOfWeek[] dows = DayOfWeek.values();
        for (TextStyle style : TextStyle.values()) {
            for (DayOfWeek d : dows) {
                System.out.format("%20s : %10s, %10s, %10s \n", style,
                    d.getDisplayName(style, Locale.CHINESE), d.getDisplayName(style, Locale.ENGLISH), d.getDisplayName(style, Locale.KOREAN));
            }
        }
    }

    @Test
    public void testTime() {
        System.out.println(Instant.now());
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(Long.MAX_VALUE);
    }
}