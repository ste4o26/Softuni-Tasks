package composition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {
        return this.data.remove(data.size() - 1);
    }

    public String peek() {
        return this.data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
