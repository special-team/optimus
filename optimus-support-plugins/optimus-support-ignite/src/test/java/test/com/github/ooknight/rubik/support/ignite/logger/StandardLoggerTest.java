package test.com.github.ooknight.rubik.support.ignite.logger;

import com.github.ooknight.rubik.support.ignite.logger.StandardLogger;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class StandardLoggerTest {

    @Test
    public void test1() {
        StandardLogger logger = new StandardLogger();
        System.out.println(logger);
    }

    @Test
    public void test2() {
        StandardLogger logger = new StandardLogger(LoggerFactory.getLogger(StandardLoggerTest.class));
        System.out.println(logger);
    }
}
