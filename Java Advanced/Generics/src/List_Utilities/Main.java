package List_Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "Alice", "Bob", "Charlie", "Renka");
        System.out.println(ListUtils.getMin(stringList));
        System.out.println(ListUtils.getMax(stringList));


        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, -256, 121, -1, 26, 8);
        System.out.println(ListUtils.getMin(integerList));
        System.out.println(ListUtils.getMax(integerList));

        List<Double> doubleList = new ArrayList<>();
        System.out.println(ListUtils.getMin(doubleList));
        System.out.println(ListUtils.getMax(doubleList));

    }
}
