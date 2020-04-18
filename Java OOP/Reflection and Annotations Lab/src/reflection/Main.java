package reflection;

import reflection.Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchMethodException {

        //this class fully qualified name
        Class<?> thisClass = reflection.Reflection.class;
        System.out.println(thisClass);

        Subject annotation = thisClass.getDeclaredAnnotation(Subject.class);
        String[] categories = annotation.categories();
        for (String category : categories) {
            System.out.println(category);
        }

        //super class fully qualified name
        Class<?> superClass = thisClass.getSuperclass();
        System.out.println(superClass);

        //super class all interfaces
        Class<?>[] superClassInterfaces = superClass.getInterfaces();
        for (Class<?> anInterface : superClassInterfaces) {
            System.out.println(anInterface);
        }

        //this class all interfaces printed
        Class<?>[] thisClassInterfaces = thisClass.getInterfaces();
        for (Class<?> anInterface : thisClassInterfaces) {
            System.out.println(anInterface);
        }

        //this class all constructors printed
        Constructor<?>[] thisClassDeclaredConstructors = thisClass.getDeclaredConstructors();
        for (Constructor<?> constructor : thisClassDeclaredConstructors) {
            System.out.println(constructor);
        }

        //get constructor with specific parameters
        Constructor<?> constructor = thisClass.getDeclaredConstructor();

        //create new instance with the specific constructor
        System.out.println(constructor.newInstance());
    }
}
