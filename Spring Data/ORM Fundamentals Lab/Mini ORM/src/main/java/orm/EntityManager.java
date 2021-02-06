package orm;

import orm.Interfaces.DatabaseContext;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;

public class EntityManager<T> implements DatabaseContext<T> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public boolean persist(T entity) {
        Field id = this.getId(entity.getClass());

    }

    public T findFirst(Class<T> table) {
        return null;
    }

    public T findFirst(Class<T> table, String where) {
        return null;
    }

    public Iterable<T> find(Class<T> table) {
        return null;
    }

    public Iterable<T> find(Class<T> table, String where) {
        return null;
    }

    private Field getId(Class entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key!"));
    }
}
