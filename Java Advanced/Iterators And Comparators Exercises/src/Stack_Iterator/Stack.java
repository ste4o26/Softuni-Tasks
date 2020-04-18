package Stack_Iterator;

import java.util.*;

public class Stack<T> implements Iterable<Integer> {

    private Node<T> top;


    public void push(T data){
        Node<T> node = new Node<>(data);
        node.next = this.top;
        this.top = node;
    }


    public T pop(){
        if (this.top == null){
            System.out.println("No elements");
            return null;
        }else {
            Node<T> nodeToPop = this.top;
            this.top = this.top.next;
            nodeToPop.next = null;
            return nodeToPop.data;
        }
    }

    public T peek(){
        return this.top.data;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator(top);
    }
}