package optimus;

import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DOMAIN {

    public static <E extends UEntity> BusinessException ENTITY_NOT_FOUND(Class<E> clazz, Object param) {
        return new BusinessException(BusinessException.Type.ENTITY_NOT_FOUND, clazz, param);
    }
}
