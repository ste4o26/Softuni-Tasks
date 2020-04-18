package Jar_Of_T;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {

        Jar<String> stringTest = new Jar<>();
        stringTest.add("torshiq");
        stringTest.add("hot chili papers");
        stringTest.add("pickles");

        System.out.println("Popped element is: " + stringTest.remove());
        ArrayDeque<String> jarOfStrings = stringTest.getJarStack();
        System.out.println("Peeked element is: " + jarOfStrings.peek());


        Jar<Integer> integerTest = new Jar<>();
        integerTest.add(131);
        integerTest.add(26);
        integerTest.add(3);

        System.out.println("Popped element is: " + integerTest.remove());
        ArrayDeque<Integer> jarOfIntegers = integerTest.getJarStack();
        System.out.println("Peeked element is: " + jarOfIntegers.peek());


        Jar<Pickle> jarOfPickles = new Jar<>();
        Pickle pickle = new Pickle("mnogo kiseli");
        jarOfPickles.add(pickle);


        System.out.println("Popped element is: " + jarOfPickles.remove());
        ArrayDeque<Pickle> jarOfPickels = jarOfPickles.getJarStack();
        System.out.println("Peeked element is: " + jarOfIntegers.peek());
    }
}
