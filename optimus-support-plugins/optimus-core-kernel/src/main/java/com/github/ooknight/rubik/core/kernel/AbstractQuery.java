package com.github.ooknight.rubik.core.kernel;

import io.ebean.Ebean;
import io.ebean.Query;

import java.lang.reflect.ParameterizedType;

//TODO STANDBY
@SuppressWarnings("all")
@Deprecated
public abstract class AbstractQuery<T> {

    protected Query<T> query;

    public AbstractQuery() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
        this.query = Ebean.createQuery(clazz);
    }
}
