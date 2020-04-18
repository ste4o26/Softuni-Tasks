package GenericScale;

public class Scale<T extends Comparable<T>> {

    private T firstItem;
    private T secondItem;

    public Scale(T firstItem, T secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }

    public T getHeavier() {
        
        if (firstItem.compareTo(secondItem) < 0){
            return secondItem;
        }else if (firstItem.compareTo(secondItem) > 0){
            return firstItem;
        }else {
            return null;
        }
    }
}
