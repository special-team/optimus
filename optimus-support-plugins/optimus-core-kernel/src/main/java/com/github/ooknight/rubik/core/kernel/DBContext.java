package com.github.ooknight.rubik.core.kernel;

import optimus.SQL;
import com.github.ooknight.rubik.core.entity.UEntity;

import com.google.common.base.Preconditions;
import io.ebean.EbeanServer;
import io.ebean.Query;
import io.ebean.UpdateQuery;

public class DBContext {

    private final EbeanServer ebean;

    public DBContext(EbeanServer ebean) {
        this.ebean = ebean;
    }

    /*
    public <E extends UEntity> void replace(E entity) {}
    */

    public <E extends UEntity> void insert(E entity) {
        ebean.insert(entity);
    }

    public void delete(Class<? extends UEntity> clazz, Long id) {
        ebean.deletePermanent(clazz, id);
    }

    public <E extends UEntity> void update(E entity) {
        Preconditions.checkNotNull(ebean.getBeanId(entity), "id is null when update : %s", entity);
        ebean.update(entity);
    }

    public <E extends UEntity> UpdateQuery update(Class<E> clazz) {
        /// use UpdateQuery<E>, do not use Update
        //O - UpdateQuery<E> :::: ebean.update(clazz).set("property", "new").where().idEq(1).update();
        //X - Update<E> :::: ebean.createUpdate(clazz, "update table set column=:new where id=:id").set("column", "new").set("id", 1).execute();
        return ebean.update(clazz);
    }

    /*
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


    public <E extends UEntity> PagedList<E> select(Class<E> clazz, Scope scope, int index, int size, String... fetchs) {
        int offset = (index - 1) * size;
        return createQuery(clazz, scope, fetchs).setMaxRows(size).setFirstRow(offset).findPagedList();
    }

    public <E extends UEntity> Query<E> createQuery(Class<E> clazz, String... fetchs) {
        Query<E> query = ebean.createQuery(clazz).setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING);
        for (String f : fetchs) {
            query.fetch(f);
        }
        return query;
    }

    public <E extends UEntity> Query<E> createQuery(Class<E> clazz, Scope scope, String... fetchs) {
        Query<E> query = ebean.createQuery(clazz).setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING).where(scope.expression(clazz));
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
    */

    public <E> Query<E> createNamedQuery(Class<E> clazz, String namedQuery) {
        return ebean.createNamedQuery(clazz, namedQuery).setDisableLazyLoading(SQL.DEFAULT_DISABLE_LAZY_LOADING);
    }
}
