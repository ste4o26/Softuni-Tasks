package harvesting_fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    private static final String HARVEST = "HARVEST";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = readSingleLineOfInput(reader);

        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();


        while (!HARVEST.equals(input)) {
            printfFieldsOfType(input, fields);
            input = readSingleLineOfInput(reader);
        }

    }

    private static void printfFieldsOfType(String input, Field[] fields) {
        Predicate<Field> isFieldPrivate = field -> Modifier.isPrivate(field.getModifiers());
        Predicate<Field> isFieldProtected = field -> Modifier.isProtected(field.getModifiers());
        Predicate<Field> isFieldPublic = field -> Modifier.isPublic(field.getModifiers());
        Consumer<Field> printFieldData = field -> System.out.println(String.format("%s %s %s",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()));

        switch (input) {
            case "private":
                Arrays.stream(fields)
                        .filter(isFieldPrivate)
                        .forEach(printFieldData);
                break;

            case "protected":
                Arrays.stream(fields)
                        .filter(isFieldProtected)
                        .forEach(printFieldData);
                break;

            case "public":
                Arrays.stream(fields)
                        .filter(isFieldPublic)
                        .forEach(printFieldData);
                break;

            default:
                Arrays.stream(fields)
                        .forEach(printFieldData);
        }
    }

    private static String readSingleLineOfInput(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
