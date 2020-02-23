package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       /* int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .sorted((firstNumber, secondNumber) -> secondNumber.compareTo(firstNumber))
                .toArray(size -> new int[size]);
    TO DO WITH ARRAY !!!

    */

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .sorted((firstNumber, secondNumber) -> secondNumber.compareTo(firstNumber))
                .limit(3)
                .collect(Collectors.toList());

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
