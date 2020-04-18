package Listy_Iterator;

import java.util.Iterator;
import java.util.List;

public class CustomListIterator implements Iterator<String> {
    private List<String> elements;
    private int nextIndex;

    public CustomListIterator(List<String> elements) {
        this.elements = elements;
        this.nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return this.nextIndex < elements.size();
    }

    @Override
    public String next() {
       return this.elements.get(nextIndex++);
    }
}
