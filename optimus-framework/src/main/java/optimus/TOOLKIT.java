package optimus;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class TOOLKIT {

    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String TIME_FORMAT = "HH:mm:ss";

    private TOOLKIT() {
    }

    public static LocalDateTime NOW() {
        return LocalDateTime.now();
    }

    public static LocalDate CURRENT_DATE() {
        return LocalDate.now();
    }

    public static LocalTime CURRENT_TIME() {
        return LocalTime.now();
    }

    public static LocalDateTime CURRENT_DATE_TIME() {
        return LocalDateTime.now();
    }

    public static String TO_JSON_STRING(Object o) {
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue);
    }

    public static String MESSAGE(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"
        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template, templateStart, template.length());
        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }
        return builder.toString();
    }
}
