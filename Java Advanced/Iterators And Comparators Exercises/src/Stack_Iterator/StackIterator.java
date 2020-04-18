package Stack_Iterator;

import java.util.Iterator;

public class StackIterator <T> implements Iterator<T> {

    private Node<T> top;

    public StackIterator(Node<T> top) {
        this.top = top;
    }

    @Override
    public boolean hasNext() {
        return top != null;
    }

    @Override
    public T next() {
        T data = this.top.data;
        this.top = this.top.next;
        return data;
    }
}