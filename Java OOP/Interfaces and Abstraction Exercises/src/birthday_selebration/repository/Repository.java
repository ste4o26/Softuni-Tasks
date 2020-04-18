package birthday_selebration.repository;

public interface Repository<T> extends Iterable<T>{
    void add(T element);

    int size();

    T get(int index);
}
