package Jar_Of_T;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> jarStack = new ArrayDeque<>();

//    public Jar() {
//        jarStack = new ArrayDeque<>();
//    }

    //add an element at the top of the jar
    public void add(T element){
        this.jarStack.push(element);
    }

    //removing topmostElement
    public T remove(){
       return this.jarStack.pop();
    }

    public ArrayDeque<T> getJarStack() {
        return jarStack;
    }
}
