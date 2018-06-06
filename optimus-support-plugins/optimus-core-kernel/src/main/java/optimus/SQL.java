package optimus;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@UtilityClass
public final class SQL {

    public static final boolean DEFAULT_DISABLE_LAZY_LOADING = true;

    public static LocalDate CURRENT_DATE() {
        return TOOLKIT.CURRENT_DATE();
    }

    public static LocalDateTime NOW() {
        return TOOLKIT.NOW();
    }

    public static boolean NOT_NULL(Object param) {
        return Objects.nonNull(param);
    }
}
