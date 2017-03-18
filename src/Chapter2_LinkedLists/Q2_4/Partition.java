package Chapter2_LinkedLists.Q2_4;

import Chapter2_LinkedLists.MyLinkedList;

/**
 * Created by selimkonuk on 19/03/2017.
 */
public class Partition {

    public boolean helper(MyLinkedList.Node node, int partition){
        MyLinkedList.Node current = node.next;
        while(current != null ){
            if((int) current.item < partition){
                int temp = (int) current.item;
                current.item = node.item;
                node.item = temp;
                return true;
            }

            current = current.next;
        }
        return false;
    }

    public void partiteMe(MyLinkedList.Node node, int partition){

        while(node != null){
            if((int) node.item >= partition && node.next != null){
                if (!helper(node , partition))
                    return;
            }
            node = node.next;
        }


    }


    public static void main(String args[]){
        MyLinkedList l = new MyLinkedList();
        l.addLast(3);
        l.addLast(8);
        l.addLast(1);
        l.addLast(6);
        l.addLast(3);
        l.addLast(2);
        l.addLast(5);
        l.addLast(9);
        l.addLast(2);
        l.addLast(4);

        Partition p = new Partition();
        p.partiteMe(l.head,4);
        l.printMyList();
    }
}
