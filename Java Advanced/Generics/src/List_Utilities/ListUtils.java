package List_Utilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()){
            System.out.println();
            throw new IllegalArgumentException();
        }

        T bestItem = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T currentItem = list.get(i);

            if (currentItem.compareTo(bestItem) < 0) {
                bestItem = currentItem;
            }
        }

        return bestItem;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()){
            System.out.println();
            throw new IllegalArgumentException();
        }

        T bestItem = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T currentItem = list.get(i);
            if (currentItem.compareTo(bestItem) > 0) {
                bestItem = currentItem;
            }
        }
        return bestItem;
    }
}
