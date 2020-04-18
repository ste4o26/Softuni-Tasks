package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomList<String>();

        String inputLine = reader.readLine();
        while (!"END".equals(inputLine)) {
            CommandInterpreter.executeCommand(customList, inputLine);
            inputLine = reader.readLine();
        }
    }
}
