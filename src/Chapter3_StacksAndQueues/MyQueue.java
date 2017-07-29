package Chapter3_StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selimkonuk on 29/07/2017.
 */
public class MyQueue<T> {

    private List<T> queue;
    private int size;

    public MyQueue(){
        queue = new ArrayList<T>();
        size = 0;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public T front(){
        if(isEmpty()){
            return null;
        }
        return queue.get(0);
    }

    public void enqueue(T item){
        queue.add(item);
        size++;
    }

    public void dequeue(){
        if(!isEmpty()){
            queue.remove(0);
            size--;
        }
    }

    public void print(){
        if(!isEmpty()){
            for(int i=size-1; i> 0 ;i--)
                System.out.print(queue.get(i) + " - ");
            System.out.print(queue.get(0));
            System.out.println();
        }
    }

    public static void main(String args[]){
        MyQueue<Integer> _myqueue = new MyQueue<>();
        _myqueue.enqueue(1);
        _myqueue.enqueue(2);
        _myqueue.enqueue(3);
        _myqueue.enqueue(4);
        _myqueue.enqueue(5);
        _myqueue.print();
        System.out.println(_myqueue.front());


    }

}
