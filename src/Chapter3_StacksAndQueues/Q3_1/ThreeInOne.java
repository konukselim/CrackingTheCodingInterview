package Chapter3_StacksAndQueues.Q3_1;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by selimkonuk on 31/07/2017.
 */
public class ThreeInOne {

    private static class Stacks{
        public int begin = 0;
        public int end = 0;
    }

    private Stacks[] stacks;
    private List<Integer> myArray;

    public ThreeInOne(int numberOfStacks){
        stacks = new Stacks[numberOfStacks];
        for(int i=0; i<numberOfStacks ;i++){
            stacks[i] = new Stacks();
        }

        myArray = new ArrayList<>();
    }

    public void swap(int indice , int with){
        int temp = myArray.get(indice);
        myArray.set(indice , myArray.get(with));
        myArray.set(with , temp);
    }

    public void putToTheLeftIndex(int from, int to){
        while(from > to){
            swap(from , from-1);
            from--;
        }
    }

    public void putToTheRightIndex(int from, int to){
        while(from < to){
            swap(from , from+1);
            from++;
        }
    }

    public void push(int toStack, int value){
        if(toStack < 0 || toStack >= stacks.length){
            throw new ArrayIndexOutOfBoundsException();
        }

        myArray.add(value);
        putToTheLeftIndex(myArray.size()-1 , stacks[toStack].end);

        stacks[toStack].end++;
        for(int i = toStack +1; i < stacks.length ;i++){
            stacks[i].begin++;
            stacks[i].end++;
        }

    }

    public int pop(int stackId){
        if(stacks[stackId].begin == stacks[stackId].end){
            throw new EmptyStackException();
        }

        int indice = stacks[stackId].end-1;
        int elem = myArray.get(indice);

        putToTheRightIndex(indice, myArray.size()-1);
        myArray.remove(myArray.size()-1);

        stacks[stackId].end--;
        for(int i = stackId +1; i < stacks.length ;i++){
            stacks[i].begin--;
            stacks[i].end--;
        }
        return elem;
    }

    public int top(int stackId){
        if(stacks[stackId].begin == stacks[stackId].end){
            throw new EmptyStackException();
        }

        return myArray.get(stacks[stackId].end-1);
    }

    /*public static void main(String args[]){

        ThreeInOne t = new ThreeInOne(3);
        t.push(0 , 4);
        t.push(0, 3);
        t.push(2,9);
        t.push(1,1);
        t.push(2,6);
        t.push(1,8);
        t.pop(2);
        t.pop(0);

        System.out.println(t.top(0));
        System.out.println(t.top(1));
        System.out.println(t.top(2));

        System.out.println(t.myArray);
        for(int i=0; i<t.stacks.length ;i++){
            System.out.println(t.myArray.subList(t.stacks[i].begin , t.stacks[i].end));
        }

    }*/

}
