package high_quality_mistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Reflection.class;

        Consumer<Field> printMessageForField = field ->
                System.out.println(
                        String.format("%s must be private!",
                                field.getName()));

        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields)
                .filter(Main::IsModifierNotPrivate)
                .sorted(Comparator.comparing(Field::getName))
                .forEach(printMessageForField);


        Consumer<Method> printMessageForGetters = getter ->
                System.out.println(
                        String.format("%s have to be public!",
                                getter.getName()));

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .filter(Main::isGetter)
                .filter(Main::IsModifierNotPublic)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(printMessageForGetters);

        Consumer<Method> printMessageForSetters = setter ->
                System.out.println(
                        String.format("%s have to be private!",
                                setter.getName()));

        Arrays.stream(declaredMethods)
                .filter(Main::isSetter)
                .filter(Main::IsModifierNotPrivate)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(printMessageForSetters);
    }

    private static boolean isSetter(Method method) {
        return method
                .getName()
                .startsWith("set");
    }

    private static boolean isGetter(Method method) {
        return method
                .getName()
                .startsWith("get");
    }

    private static boolean IsModifierNotPrivate(Field field) {
        int modifiers = field.getModifiers();
        return !Modifier.isPrivate(modifiers);
    }

    private static boolean IsModifierNotPrivate(Method method) {
        int modifiers = method.getModifiers();
        return !Modifier.isPrivate(modifiers);
    }

    private static boolean IsModifierNotPublic(Method method) {
        int modifiers = method.getModifiers();
        return !Modifier.isPublic(modifiers);
    }
}
