package com.github.ooknight.rubik.core.entity;

import io.ebean.annotation.EnumValue;
import io.ebean.util.AnnotationUtil;

public interface State {

    default int code() {
        try {
            String name = ((Enum<?>) this).name();
            EnumValue value = AnnotationUtil.findAnnotation(this.getClass().getDeclaredField(name), EnumValue.class);
            return Integer.parseInt(value.value());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
