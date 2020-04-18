package Generic_Count_Method;

public class Box<T extends Comparable<T>> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
