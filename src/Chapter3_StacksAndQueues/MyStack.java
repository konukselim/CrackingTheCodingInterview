package Chapter3_StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selimkonuk on 29/07/2017.
 */
public class MyStack<T> {

    private List<T> stack;
    private int size;

    public MyStack(){
        stack = new ArrayList<T>();
        size = 0;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public T top(){
        if(size == 0){
            return null;
        }
        return stack.get(size-1);
    }

    public void push(T item){
        stack.add(item);
        size++;
    }

    public void pop(){
        if(size != 0){
            stack.remove(size-1);
            size--;
        }
    }

    public T topAndPop(){
        T top = top();
        pop();
        return top;
    }

    public void print(){
        for(int i= size-1; i>= 0 ;i--){
            System.out.println(stack.get(i));
        }
    }

}
