package getters_and_setters;

import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Reflection.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        List<Method> getters = getAllGetters(declaredMethods);
        List<Method> setters = getAllSetters(declaredMethods);

        getters = sortMethodsByName(getters);
        setters = sortMethodsByName(setters);

        printGetters(getters);
        printSetters(setters);
    }

    private static void printSetters(List<Method> setters) {
        for (Method setter : setters) {
            String setterName = setter.getName();
            Class<?>[] parameterTypes = setter.getParameterTypes();
            String parameterType = parameterTypes[0].getName();
            System.out.printf("%s and will set field of class %s%n",setterName , parameterType);
        }
    }

    private static void printGetters(List<Method> getters) {
        for (Method getter : getters) {
            String getterName = getter.getName();
            String returnType = getter.getReturnType().getName();
            System.out.printf("%s will return class %s%n",getterName , returnType);
        }
    }

    private static List<Method> sortMethodsByName(List<Method> list) {
        List<Method> sortedList = new ArrayList<>();

        sortedList = list
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList());

        return sortedList;
    }

    private static List<Method> getAllGetters(Method[] declaredMethods) {
        List<Method> getters = new ArrayList<>();

        getters = Arrays.stream(declaredMethods)
                .filter(getter -> getter.getName().startsWith("get"))
                .collect(Collectors.toList());

        return getters;
    }

    private static List<Method> getAllSetters(Method[] declaredMethods) {
        List<Method> setters = new ArrayList<>();

        setters = Arrays.stream(declaredMethods)
                .filter(getter -> getter.getName().startsWith("set"))
                .collect(Collectors.toList());

        return setters;
    }
}
