package blackBoxInteger;

import blackBoxInteger.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final String END = "END";

    public static void main(String[] args) throws IOException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, NoSuchFieldException {


        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Method[] methods = clazz.getDeclaredMethods();
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = readSingleLineOfInput(reader);
        while (!END.equals(input)){
            String[] tokens = input.split("_");
            String commandStr = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            CommandParser parser = new CommandParser();
            Command command = parser.parseCommand(commandStr);
            command.execute(blackBoxInt, value);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));

            input = readSingleLineOfInput(reader);
        }



    }

    private static String readSingleLineOfInput(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
