package optimus;

import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

public final class DOMAIN {

    private DOMAIN() {
    }

    public static <E extends UEntity> BusinessException ENTITY_NOT_FOUND(Class<E> clazz, Long id) {
        return new BusinessException(BusinessException.Type.ENTITY_NOT_FOUND, clazz, id);
    }
}
