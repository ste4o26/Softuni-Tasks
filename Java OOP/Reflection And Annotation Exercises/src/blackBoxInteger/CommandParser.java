package blackBoxInteger;

import blackBoxInteger.commands.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandParser {
    private static final String PATH_TO_COMMANDS = "blackBoxInteger.commands.";

    public Command parseCommand(String commandStr) {
        String commandClassName = commandStr
                .substring(0, 1)
                .toUpperCase() +
                commandStr.substring(1) +
                "Command";

        Command command = null;
        try {
            Class<?> clazz = Class.forName(PATH_TO_COMMANDS + commandClassName);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object object = constructor.newInstance();

            if (object instanceof Command) {
                command = (Command) object;
            }

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                InvocationTargetException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

        return command;
    }
}
