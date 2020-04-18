package blackBoxInteger.commands;

import blackBoxInteger.BlackBoxInt;

import java.lang.reflect.InvocationTargetException;

public interface Command {
    void execute(BlackBoxInt blackBoxInt, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
