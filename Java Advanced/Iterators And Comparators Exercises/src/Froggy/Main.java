package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String[] stones = Arrays.stream(input.split(",\\s+"))
                .toArray(String[]::new);

        Lake lake = new Lake(stones);

        StringBuilder result = new StringBuilder();
        for (String stone : lake) {
            result.append(stone + ", ");
        }

        System.out.println(result.substring(0, result.length() - 2));
    }
}
