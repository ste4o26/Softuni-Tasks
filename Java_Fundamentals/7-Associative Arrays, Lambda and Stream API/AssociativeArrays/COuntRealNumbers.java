package AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

public class COuntRealNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Double, Integer> numbersOccurrences = new TreeMap<Double, Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            double currentNumber = numbers.get(i);
            if(numbersOccurrences.containsKey(currentNumber)){
                int numberCount = numbersOccurrences.get(currentNumber);
                numbersOccurrences.put(currentNumber, numberCount + 1);
            }else {
                numbersOccurrences.put(currentNumber, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numbersOccurrences.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
