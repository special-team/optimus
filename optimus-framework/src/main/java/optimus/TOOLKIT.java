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
}
