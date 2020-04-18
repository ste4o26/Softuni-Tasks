package birthday_selebration.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositoryImpl<T> implements Repository<T> {
    private List<T> repository;

    public RepositoryImpl() {
        this.repository = new ArrayList<>();
    }


    @Override
    public void add(T element) {
        this.repository.add(element);
    }

    @Override
    public int size() {
        return this.repository.size();
    }

    @Override
    public T get(int index) {
        return this.repository.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new RepositoryIterator<T>(this);
    }
}
