package Chapter3_StacksAndQueues.Q3_2;

import java.util.EmptyStackException;

/**
 * Created by selimkonuk on 09/08/2017.
 */
public class StackMin {

    private static class Node{
        public int value;
        public int min;
        public Node next;

        public Node(int value , int min){
            this.value = value;
            this.min = min;
        }
    }

    private Node top ;

    public boolean isEmpty(){
        if (top == null)
            return true;
        return false;
    }

    public void push(int value){
        Node n;

        if (isEmpty()){
            n = new Node(value , value);
        }
        else{
            int min = ((value < top.min) ? value : top.min);
            n = new Node(value , min);
            n.next = top;
        }

        top = n;
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        int value = top.value;
        top = top.next;

        return value;
    }

    public int min(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.min;
    }
}
