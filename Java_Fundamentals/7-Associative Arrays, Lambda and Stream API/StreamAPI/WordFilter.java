package StreamAPI;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] filteredWords = Arrays.stream(sc.nextLine().split(" "))
                .filter(word -> word.length() % 2 == 0)
                .toArray(size -> new String[size]);
                //.toArray(String[]::new);

        for (String word : filteredWords) {
            System.out.println(word);
        }
    }
}
