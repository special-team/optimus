package com.github.ooknight.rubik.core.query;

import optimus.DOMAIN;
import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.core.session.Scope;

import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.typequery.TQRootBean;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class QueryEngine {

    public static <Q extends TQRootBean<?, Q>> Q QUERY(@NonNull Class<Q> clazz) {
        try {
            return clazz.newInstance().setDisableLazyLoading(false);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("error when create bean query for " + clazz, e);
        }
    }

    public static <Q extends TQRootBean<?, Q>> Q QUERY(@NonNull Class<Q> clazz, @NonNull Scope scope) {
        try {
            Q query = clazz.newInstance().setDisableLazyLoading(false);
            Class entityClass = (Class) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
            query.getExpressionList().add(scope.expression(entityClass));
            return query;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("error when create bean query for " + clazz, e);
        }
    }

    public static <E extends UEntity> List<E> SELECT(final Class<E> clazz) {
        return createQuery(clazz).findList();
    }

    public static <E extends UEntity> List<E> SELECT(final Class<E> clazz, final Scope scope) {
        return createQuery(clazz, scope).findList();
    }

    public static <E extends UEntity> Optional<E> SELECT(final Class<E> clazz, final Long id) {
        return createQuery(clazz).setId(id).findOneOrEmpty();
    }

    public static <E extends UEntity> Optional<E> SELECT(final Class<E> clazz, final Scope scope, final Long id) {
        return createQuery(clazz, scope).setId(id).findOneOrEmpty();
    }

    public static <E extends UEntity> E GETONE(final Class<E> clazz, final Long id) {
        return createQuery(clazz).setId(id).findOneOrEmpty().orElseThrow(() -> DOMAIN.ENTITY_NOT_FOUND(clazz, id));
    }

    public static <E extends UEntity> E GETONE(final Class<E> clazz, final Scope scope, final Long id) {
        return createQuery(clazz, scope).setId(id).findOneOrEmpty().orElseThrow(() -> DOMAIN.ENTITY_NOT_FOUND(clazz, id));
    }

    /*
     * private ========= ========= =========
     */

    private static <E extends UEntity> Query<E> createQuery(Class<E> clazz) {
        return Ebean.createQuery(clazz).setDisableLazyLoading(false);
    }

    private static <E extends UEntity> Query<E> createQuery(Class<E> clazz, Scope scope) {
        return Ebean.createQuery(clazz).setDisableLazyLoading(false).where(scope.expression(clazz));
    }
}
