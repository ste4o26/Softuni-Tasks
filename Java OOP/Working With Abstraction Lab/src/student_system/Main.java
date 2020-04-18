package student_system;

import java.util.Scanner;

public class Main {

    private static final String EXIT = "Exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();
        while (!EXIT.equals(input))
        {
            String[] tokens = input.split("\\s+");
            studentSystem
                    .getCommandParser()
                    .parseCommand(tokens);

            input = scanner.nextLine();
        }
    }
}
