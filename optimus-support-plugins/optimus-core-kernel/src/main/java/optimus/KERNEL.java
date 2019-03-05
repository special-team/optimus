package optimus;

import com.github.ooknight.rubik.framework.exception.BusinessException;
import com.github.ooknight.rubik.framework.exception.BusinessExceptionType;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public final class KERNEL {

    public static BusinessException SERVICE_NOT_SUPPORT() {
        return new BusinessException(BusinessExceptionType.Default.SERVICE_NOT_SUPPORT);
    }

    public static <T extends Enum & BusinessExceptionType> BusinessException ERROR(T type) {
        return new BusinessException(type);
    }

    public static void PROPAGATE(Throwable e) {
        log.warn("todo - fix it : ", e);
        throw new RuntimeException(e);
    }
}
