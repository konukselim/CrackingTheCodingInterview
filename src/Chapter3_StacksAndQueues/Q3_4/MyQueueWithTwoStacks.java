package Chapter3_StacksAndQueues.Q3_4;

import Chapter3_StacksAndQueues.MyStack;

/**
 * Created by selimkonuk on 12/08/2017.
 */
public class MyQueueWithTwoStacks<T> {

    private MyStack<T> stack;
    private MyStack<T> tmpStack;

    public MyQueueWithTwoStacks(){
        this.stack = new MyStack();
        this.tmpStack = new MyStack();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public T front(){
        return stack.top();
    }

    public void enqueue(T item){
        while (!stack.isEmpty()){
            tmpStack.push(stack.pop());
        }

        stack.push(item);

        while (!tmpStack.isEmpty()){
            stack.push(tmpStack.pop());
        }
    }

    public T dequeue(){
        T item = stack.pop();
        return item;
    }

}
