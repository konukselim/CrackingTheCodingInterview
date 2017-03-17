package Chapter2_LinkedLists.Q2_1; /**
 * Created by selimkonuk on 17/03/2017.
 */

import Chapter2_LinkedLists.MyLinkedList;

import java.util.HashSet;


// Suppose that this is a one way LinkedList

public class RemoveDuplicates {

    // O(N)
    public static MyLinkedList withTemp(MyLinkedList l){

        MyLinkedList.Node curr = l.head;
        MyLinkedList.Node temp = null;
        HashSet container = new HashSet();

        while(curr != null){
            if(container.contains(curr.item)){
                temp.next = curr.next;
            }
            else{
                container.add(curr.item);
                temp = curr;
            }
            curr = curr.next;
        }

        return l;
    }

    // O(N^2)
    public static MyLinkedList withoutTemp(MyLinkedList l){

        MyLinkedList.Node curr = l.head;
        while(curr != null){
            MyLinkedList.Node iter = curr;
            while(iter.next != null){
                if(iter.next.item.equals(curr.item)){
                    iter.next = iter.next.next;
                }
                else{
                    iter = iter.next;
                }
            }
            curr = curr.next;
        }


        return l;
    }

    public static void main(String args[]){
        MyLinkedList l = new MyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.addLast(3);
        l.addLast(2);
        l.addLast(8);
        l.addLast(3);
        l.addLast(2);
        l.addLast(9);
        l.addLast(10);
        l.addLast(9);
        l.addLast(0);


        //withTemp(l);
        withoutTemp(l);
        l.printMyList();

    }

}
