package com.github.ooknight.rubik.core.query;

import optimus.DOMAIN;
import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.core.session.Scope;

import io.ebean.Ebean;
import io.ebean.typequery.TQRootBean;
import lombok.NonNull;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public class QueryEngine {

    public static <Q extends TQRootBean<?, Q>> Q build(@NonNull Class<Q> clazz) {
        try {
            return clazz.newInstance().setDisableLazyLoading(false);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static <Q extends TQRootBean<?, Q>> Q build(@NonNull Class<Q> clazz, @NonNull Scope scope) {
        Q query = build(clazz);
        Class entityClass = (Class) ((ParameterizedType) query.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        query.getExpressionList().add(scope.expression(entityClass));
        return query;
    }

    public static <E extends UEntity> E GETONE(final Class<E> clazz, final Long id) {
        return Ebean.createQuery(clazz).setId(id).findOneOrEmpty().orElseThrow(() -> DOMAIN.ENTITY_NOT_FOUND(clazz, id));
    }

    public static <E extends UEntity> Optional<E> SELECT(final Class<E> clazz, final Long id) {
        return Ebean.createQuery(clazz).setId(id).findOneOrEmpty();
    }
}
