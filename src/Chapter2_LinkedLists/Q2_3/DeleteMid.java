package Chapter2_LinkedLists.Q2_3;

import Chapter2_LinkedLists.MyLinkedList;

/**
 * Created by selimkonuk on 18/03/2017.
 */
public class DeleteMid<T> {

    public void delItem(MyLinkedList.Node node){
        MyLinkedList.Node pointer = node;

        while(node.next != null){
            pointer = node;
            node.item = node.next.item;
            node = node.next;
        }
        pointer.next = null;
    }

    public static void main(String args[]){
        MyLinkedList l = new MyLinkedList();
        l.addLast("aaa");
        l.addLast("bbb");
        l.addLast("ccc");
        l.addLast("ddd");
        l.addLast("eee");
        l.addLast("ccc");
        l.addLast("ttt");

        MyLinkedList.Node node = l.head.next.next.next; //ddd

        DeleteMid d = new DeleteMid();
        d.delItem(node);
        l.printMyList();

    }
}
