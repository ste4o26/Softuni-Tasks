package Listy_Iterator;

import java.util.*;

public class CustomList implements Iterable<String>{

    private List<String> elements;
    private int index;

    public CustomList(String... data) {
        this.elements = new ArrayList<>();
        this.index = 0;
        this.elements = Arrays.asList(data);
    }

    public boolean move() {
        if (this.index < this.elements.size() - 1) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return this.elements.size();
    }

    public boolean hasNext() {
        return this.index < elements.size() - 1;
    }

    public String getCurrentElement(){
        return this.elements.get(this.index);
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomListIterator(this.elements);
    }
}
