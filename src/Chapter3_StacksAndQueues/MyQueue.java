package Chapter3_StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by selimkonuk on 29/07/2017.
 */
public class MyQueue<T> {

    private static class Node<T>{
        public T item;
        public Node next;

        public Node(T item){
            this.item = item;
        }
    }

    private Node<T> front;
    private Node<T> back;

    public boolean isEmpty(){
        return (front == null);
    }

    public T front(){
        if(isEmpty())
            throw new NoSuchElementException();
        return front.item;
    }

    public void enqueue(T item ){
        Node<T> node = new Node<T>(item);

        if(isEmpty()){
            back = node;
            front = node;
        }
        else{
            back.next = node;
            back = node;
        }
    }

    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();

        T val = front.item;
        front = front.next;
        return val;
    }

}
