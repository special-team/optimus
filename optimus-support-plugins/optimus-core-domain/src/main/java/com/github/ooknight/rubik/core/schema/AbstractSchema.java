package com.github.ooknight.rubik.core.schema;

import io.ebean.typequery.TQProperty;

public abstract class AbstractSchema {

    public static String p(TQProperty property) {
        return property.toString();
    }
}
