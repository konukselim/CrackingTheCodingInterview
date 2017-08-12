package Chapter3_StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by selimkonuk on 29/07/2017.
 */
public class MyStack<T> {

    private static class Node<T>{

        private T item;
        private Node<T> next;

        public Node(T item){
            this.item = item;
        }
    }

    private Node<T> top;

    public boolean isEmpty(){
        return (top == null);
    }

    public T top(){
        if(isEmpty())
            throw new EmptyStackException();
        return top.item;
    }

    public void push(T item){
        Node<T> node = new Node<T>(item);
        node.next = top;
        top = node;
    }

    public T pop(){
        if(isEmpty())
            throw new EmptyStackException();
        T val = top();
        top = top.next;
        return val;
    }

}
