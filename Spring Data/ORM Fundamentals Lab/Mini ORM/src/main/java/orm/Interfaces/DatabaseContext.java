package orm.Interfaces;

public interface DatabaseContext<T> {
    boolean persist(T entity);

    T findFirst(Class<T> table);

    T findFirst(Class<T> table, String where);

    Iterable<T> find(Class<T> table);

    Iterable<T> find(Class<T> table, String where);
}
