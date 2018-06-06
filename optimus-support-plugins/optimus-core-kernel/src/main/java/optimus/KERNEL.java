package optimus;

import com.github.ooknight.rubik.support.core.exception.BusinessException;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public final class KERNEL {

    public static BusinessException ERROR(BusinessException.Type type) {
        return new BusinessException(type);
    }

    public static void PROPAGATE(Throwable e) {
        log.warn("todo - fix it : ", e);
        throw new RuntimeException(e);
    }
}
