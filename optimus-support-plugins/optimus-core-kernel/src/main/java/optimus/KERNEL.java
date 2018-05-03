package optimus;

import com.github.ooknight.rubik.support.core.exception.BusinessException;

public final class KERNEL {

    private KERNEL() {
    }

    public static BusinessException ERROR(String key) {
        return new BusinessException(key);
    }
}
