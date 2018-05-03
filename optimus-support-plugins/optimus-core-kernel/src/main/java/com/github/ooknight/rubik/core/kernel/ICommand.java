package com.github.ooknight.rubik.core.kernel;

import com.github.ooknight.rubik.core.session.Scope;

import io.ebean.Ebean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
@Deprecated
public interface ICommand {

    interface CREATE {

        default <T> void create(T entity) {
            Ebean.save(entity);
        }
    }

    interface GETONE<T> {

        default Optional<T> getone(Long id) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            return Ebean.find(clazz).setDisableLazyLoading(true).setId(id).findOneOrEmpty();
        }
    }

    interface GETONE_WITH_SCOPE<T> extends GETONE {

        default Optional<T> getone(Long id, Scope scope, String property) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            return Ebean.find(clazz).setDisableLazyLoading(true).setId(id).where().eq(property, scope.gid()).findOneOrEmpty();
        }
    }

    interface SELECT<T> {

        default List<T> select() {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            return Ebean.find(clazz).setDisableLazyLoading(true).findList();
        }
    }

    interface SELECT_WITH_SCOPE<T> extends SELECT {

        default List<T> select(Scope scope, String property) {
            Type[] x = this.getClass().getGenericInterfaces();
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            System.out.println("=====================================================================" + type);
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            return Ebean.find(clazz).setDisableLazyLoading(true).where().eq(property, scope.gid()).findList();
        }
    }
}
