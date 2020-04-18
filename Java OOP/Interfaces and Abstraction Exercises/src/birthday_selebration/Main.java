package birthday_selebration;

import birthday_selebration.command_manipulator.*;
import birthday_selebration.repository.Repository;
import birthday_selebration.repository.RepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String END = "End";

    public static void main(String[] args) throws IOException {

        Repository<Citizen> citizens = new RepositoryImpl<>();
        Repository<Robot> robots = new RepositoryImpl<>();
        Repository<Pet> pets = new RepositoryImpl<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!END.equals(input)) {
            String[] tokens = input.split("\\s+");
            Command command = null;
            switch (tokens[0]) {
                case "Pet":
                    command = new PetCommand(tokens, pets);
                    command.execute();
                    break;

                case "Citizen":
                    command = new CitizenCommand(tokens, citizens);
                    command.execute();
                    break;

                case "Robot":
                    command = new RobotCommand(tokens, robots);
                    command.execute();
                    break;
            }

            input = reader.readLine();
        }

        String year = reader.readLine();
        List<String> birthDatesFromYear = getBirthDatesFromYear(year, citizens, pets);
        printList(birthDatesFromYear);

    }

    private static void printList(List<String> birthDatesFromYear) {
        birthDatesFromYear.forEach(System.out::println);
    }

    public static List<String> getBirthDatesFromYear(String year, Repository<Citizen> citizens, Repository<Pet> pets) {
        List<String> result = new ArrayList<>();

        for (Citizen citizen : citizens) {
            String birthDate = citizen.getBirthDate();
            if (birthDate.endsWith(year)) {
                result.add(birthDate);
            }
        }

        for (Pet pet : pets) {
            String birthDate = pet.getBirthDate();
            if (birthDate.endsWith(year)) {
                result.add(birthDate);
            }
        }
        return result;
    }
}
