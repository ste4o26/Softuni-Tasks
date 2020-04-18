package Stack_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        String input = reader.readLine();
        while (!"END".equals(input)){

            String command = input.split("\\s+")[0];

            Integer[] data = Arrays.stream(input.split("[, ]+"))
                    .skip(1)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            CommandExecutor.executeCommand(command,stack, data);

            input = reader.readLine();
        }


        for (Integer element : stack) {
            System.out.println(element);
        }

        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}
