package com.github.ooknight.rubik.core.kernel;

import optimus.SQL;
import com.github.ooknight.rubik.core.entity.UEntity;
import com.github.ooknight.rubik.core.session.Scope;

import io.ebean.EbeanServer;
import io.ebean.PagedList;
import io.ebean.Query;
import io.ebean.UpdateQuery;
import io.ebean.typequery.TQRootBean;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public class DBContext {

    private final EbeanServer server;

    public DBContext(EbeanServer server) {
        this.server = server;
    }

    /*
    public <E extends UEntity> void replace(E entity) {}
    */

    public <E extends UEntity> void insert(E entity) {
        server.insert(entity);
    }

    public void delete(Class<? extends UEntity> clazz, Long id) {
        server.deletePermanent(clazz, id);
    }

    public <E extends UEntity> void update(E entity) {
        server.update(entity);
    }

    public <E extends UEntity> UpdateQuery update(Class<E> clazz) {
        /// use UpdateQuery<E>, do not use Update
        //O - UpdateQuery<E> :::: server.update(clazz).set("property", "new").where().idEq(1).update();
        //X - Update<E> :::: server.createUpdate(clazz, "update table set column=:new where id=:id").set("column", "new").set("id", 1).execute();
        return server.update(clazz);
    }

    public <E extends UEntity> Optional<E> getone(Class<E> clazz, Long id, String... fetchs) {
        return createQuery(clazz, fetchs).setId(id).findOneOrEmpty();
    }

    public <E extends UEntity> Optional<E> getone(Class<E> clazz, Long id, Scope scope, String... fetchs) {
        return createQuery(clazz, scope, fetchs).setId(id).findOneOrEmpty();
    }

    public <E extends UEntity> List<E> select(Class<E> clazz, String... fetchs) {
        return createQuery(clazz, fetchs).findList();
    }

    public <E extends UEntity> List<E> select(Class<E> clazz, Scope scope, String... fetchs) {
        return createQuery(clazz, scope, fetchs).findList();
    }

    /**
     * page select
     *
     * @param clazz  clazz
     * @param scope  scope
     * @param index  index (start at 1)
     * @param size   size
     * @param fetchs fetchs
     * @param <E>    E
     * @return result
     */
    public <E extends UEntity> PagedList<E> select(Class<E> clazz, Scope scope, int index, int size, String... fetchs) {
        int offset = (index - 1) * size;
        return createQuery(clazz, scope, fetchs).setMaxRows(size).setFirstRow(offset).findPagedList();
    }

    public <E extends UEntity> Query<E> createQuery(Class<E> clazz, String... fetchs) {
        Query<E> query = server.createQuery(clazz).setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING);
        for (String f : fetchs) {
            query.fetch(f);
        }
        return query;
    }

    public <E extends UEntity> Query<E> createQuery(Class<E> clazz, Scope scope, String... fetchs) {
        Query<E> query = server.createQuery(clazz).setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING).where(scope.expression(clazz));
        for (String f : fetchs) {
            query.fetch(f);
        }
        return query;
    }

    public <E extends UEntity, Q extends TQRootBean<E, Q>> Q createQuery(Class<Q> clazz, Scope scope) {
        Q query = createQuery(clazz);
        if (scope != null) {
            Class entityClass = (Class) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
            query.getExpressionList().add(scope.expression(entityClass));
        }
        return query;
    }

    public <E extends UEntity, Q extends TQRootBean<E, Q>> Q createQuery(Class<Q> clazz) {
        try {
            return clazz.newInstance().setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING);
        } catch (Exception e) {
            throw new RuntimeException("error when create query for " + clazz, e);
        }
    }

    public <E> Query<E> createNamedQuery(Class<E> clazz, String namedQuery) {
        return server.createNamedQuery(clazz, namedQuery).setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING);
    }
}
