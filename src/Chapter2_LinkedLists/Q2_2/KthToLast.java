package Chapter2_LinkedLists.Q2_2;

import Chapter2_LinkedLists.MyLinkedList;

/**
 * Created by selimkonuk on 18/03/2017.
 */

// O(N)
public class KthToLast<T> {
    public T item = null;
    public int count = 0;


    public T kthlast(MyLinkedList.Node current , int k){
        recursiveLastK(current , k);
        if(item == null){
            System.out.println("Wrong k :(");
        }
        return item;
    }

    public void recursiveLastK(MyLinkedList.Node current , int k){
        if(current == null){
            return;
        }

        recursiveLastK(current.next , k);
        count++;
        if(count == k){
            item = (T) current.item;
        }
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

        KthToLast k = new KthToLast();
        System.out.println(k.kthlast(l.head , 13));
    }
}
