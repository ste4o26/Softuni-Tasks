package Listy_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);

        CustomList elements = new CustomList(data);

        String inputCommand = reader.readLine();
        while (!"END".equals(inputCommand)) {
            CommandExecutor.executeCommand(inputCommand, elements);
            inputCommand = reader.readLine();
        }
    }
}
