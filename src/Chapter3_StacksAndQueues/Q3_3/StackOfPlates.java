package Chapter3_StacksAndQueues.Q3_3;

import Chapter3_StacksAndQueues.MyStack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by selimkonuk on 09/08/2017.
 */
public class StackOfPlates<T> {

    private int stackLimit;
    private int currentPlatesNumber;
    private List<MyStack<T>> stackPlates;

    public StackOfPlates(int limit) throws Exception {
        if (limit < 1){
            throw new Exception("Invalid limit size");
        }

        this.stackLimit = limit;
        this.currentPlatesNumber = 0;
        this.stackPlates = new ArrayList<>();
    }

    public MyStack top(){
        if (stackPlates.isEmpty()){
            throw new EmptyStackException();
        }
        return stackPlates.get(stackPlates.size() - 1);
    }

    public void push(T item){
        if (stackPlates.isEmpty() || currentPlatesNumber == stackLimit){
            MyStack stack = new MyStack();
            stack.push(item);
            stackPlates.add(stack);
            currentPlatesNumber = 1;
        }
        else{
            top().push(item);
            currentPlatesNumber++;
        }
    }

    public T pop(){
        T topItem = (T) top().pop();
        currentPlatesNumber--;

        if (top().isEmpty()){
            stackPlates.remove(stackPlates.size() -1);
            currentPlatesNumber = stackLimit; //Doesn't matter if stackPlates empty
        }


        return topItem;
    }

    public T popAt(int index){
        if (index > stackPlates.size() || index < 1){
            throw new IndexOutOfBoundsException();
        }

        List<MyStack<T>> tempStacks = new ArrayList<>();
        int loopCount = stackPlates.size() - index;

        for (int i = index; i < stackPlates.size() ; i++) {
            tempStacks.add(stackPlates.get(i));
        }
        while (loopCount > 0){
            stackPlates.remove(stackPlates.size() -1);
            loopCount--;
        }

        if (index != stackPlates.size()){
            currentPlatesNumber = stackLimit-1;
        }

        T topAtIndex = pop();

        pushTempStack(tempStacks);
        return topAtIndex;
    }

    public void pushTempStack(List<MyStack<T>> tempStacks){
        if (!tempStacks.isEmpty()){
            T top = tempStacks.get(tempStacks.size() -1 ).pop();
            if( tempStacks.get(tempStacks.size()-1).isEmpty()){
                tempStacks.remove(tempStacks.size()-1);
            }
            pushTempStack(tempStacks);
            push(top);
        }
    }
}
