package CustomList;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {

    private List<T> customList;


    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public List<T> getCustomList() {
        return customList;
    }

    public void add(T element) {
        this.customList.add(element);
    }


    public T remove(int index) {
        return this.customList.remove(index);
    }


    public boolean contains(T element) {
        return this.customList.contains(element);
    }


    public void swap(int firstIndex, int secondIndex) {
        T temp = customList.get(firstIndex);

        T boxToSwapWith = this.customList.get(secondIndex);
        this.customList.set(firstIndex, boxToSwapWith);

        this.customList.set(secondIndex, temp);
    }


    public int countGreaterThan(T elementToCompareWith) {
        int count = 0;
        for (T element : customList) {
            if (element.compareTo(elementToCompareWith) > 0) {
                count++;
            }
        }

        return count;
    }


    public T getMax() {
        if (this.customList.isEmpty()) {
            System.out.println();
            throw new IllegalArgumentException();
        }

        T maxElement = this.customList.get(0);
        for (T element : customList) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }

        return maxElement;
    }

    public T getMin() {
        if (this.customList.isEmpty()) {
            System.out.println();
            throw new IllegalArgumentException();
        }

        T minElement = this.customList.get(0);
        for (T element : customList) {
            if (element.compareTo(minElement) < 0) {
                minElement = element;
            }
        }

        return minElement;
    }

    public void printEachElement() {
        for (T element : customList) {
            System.out.println(element);
        }
    }

    public void sort() {
        this.customList.sort(Comparator.naturalOrder());
    }
}
