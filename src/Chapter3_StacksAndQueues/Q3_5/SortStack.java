package Chapter3_StacksAndQueues.Q3_5;

import Chapter3_StacksAndQueues.MyStack;

/**
 * Created by selimkonuk on 12/08/2017.
 */
public class SortStack {

    private MyStack stack;

    public SortStack(MyStack<Integer> stack){
        this.stack = stack;
    }

    public MyStack sort(){
        MyStack tmpStack = new MyStack();

        while(!stack.isEmpty()){
            int topItem = (int) stack.pop();
            int count = 0;
            while (!tmpStack.isEmpty() &&  (int) tmpStack.top() <  topItem){
                stack.push(tmpStack.pop());
                count++;
            }

            tmpStack.push(topItem);
            while (count > 0){
                tmpStack.push(stack.pop());
                count--;
            }
        }

        return tmpStack;
    }
}
