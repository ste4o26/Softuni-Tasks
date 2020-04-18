package birthday_selebration.repository;

import birthday_selebration.repository.RepositoryImpl;

import java.util.Iterator;

public class RepositoryIterator<T> implements Iterator<T> {
    private int index;
    private RepositoryImpl<T> repository;

    public RepositoryIterator(RepositoryImpl<T> repository) {
        this.repository = repository;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.repository.size();
    }

    @Override
    public T next() {
        return this.repository.get(index++);
    }
}
