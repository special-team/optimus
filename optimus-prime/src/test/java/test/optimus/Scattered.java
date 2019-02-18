package test.optimus;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

@Ignore
public class Scattered {

    @Test
    public void testDateTimeFormt() {
        for (Locale locale : Locale.getAvailableLocales()) {
            String k = locale.toString();
            String v1 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale).format(new Date());
            String v2 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale).format(new Date());
            String v3 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale).format(new Date());
            String v4 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale).format(new Date());
            System.out.format("%-30s : %-50s : %-50s : %-50s : %-50s \n", k, v1, v2, v3, v4);
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
    public void testI18n() {
        System.out.println(MessageFormat.format("the number is {0} and {1}", 1, 2));
    }
}

