package blackBoxInteger.commands;

import blackBoxInteger.BlackBoxInt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class CommandImpl implements Command{
    private String methodName;

    public CommandImpl(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public void execute(BlackBoxInt blackBoxInt, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Method method = clazz.getDeclaredMethod(this.getMethodName(), int.class);
        method.setAccessible(true);
        method.invoke(blackBoxInt, value);
    }

    protected abstract String getMethodName();
}
