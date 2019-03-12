package optimus;

import com.google.common.collect.Lists;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@UtilityClass
public final class WEB {

    public static <T> T PARAM(T param, T defaultValue) {
        return param == null ? defaultValue : param;
    }

    public static List<LocalDate> DATE_LIST(LocalDate begin, LocalDate end) {
        List<LocalDate> r = Lists.newArrayList();
        for (LocalDate t = begin; t.compareTo(end) < 0; t = t.plusDays(1)) {
            r.add(t);
        }
        return r;
    }

    public static List<String> DATE_LIST_STRING(LocalDate begin, LocalDate end) {
        List<String> r = Lists.newArrayList();
        for (LocalDate t = begin; t.compareTo(end) < 0; t = t.plusDays(1)) {
            r.add(t.format(DateTimeFormatter.ISO_DATE));
        }
        return r;
    }

    public static E404 ERROR_HTTP_404() {
        return new E404();
    }

    public static E500 ERROR() {
        return new E500();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class E404 extends RuntimeException {

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class E500 extends RuntimeException {

    }
}
