package CustomComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] evens = Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .toArray(Integer[]::new);

        Integer[] odds = Arrays.stream(numbers)
                .filter(number -> number % 2 != 0)
                .toArray(Integer[]::new);


        Comparator<Integer> numbersComparator = (first, second) -> first - second;
        Arrays.sort(evens, numbersComparator);
        Arrays.sort(odds, numbersComparator);

        for (int i = 0; i < evens.length; i++) {
            numbers[i] = evens[i];
        }


        for (int i = 0; i < odds.length; i++) {
            numbers[i + evens.length] = odds[i];
        }


        Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
    }
}
