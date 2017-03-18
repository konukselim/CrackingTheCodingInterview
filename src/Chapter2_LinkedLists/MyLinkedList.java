package Chapter2_LinkedLists; /**
 * Created by selimkonuk on 17/03/2017.
 */

public class MyLinkedList<T>{

    private int size;
    public Node head;
    public Node back;

    public class Node{
        public T item;
        public Node next;
        public Node prev;
    }

    public MyLinkedList(){
        head = null;
        back = null;
        size = 0;
    }

    public void addLast(T item){
        Node node = new Node();
        if(head == null){
            node.next = null;
            node.prev = null;
            node.item = item;

            head = node;
            back = node;
        }
        else{
            node.next = null;
            node.prev = back;
            node.item = item;

            back.next = node;
            back = node;
        }
        size++;
    }

    public void addFirst(T item){
        Node node = new Node();
        if(head == null){
            node.next = null;
            node.prev = null;
            node.item = item;

            head = node;
            back = node;
        }
        else{
            node.next = head;
            node.prev = null;
            node.item = item;

            head.prev = node;
            head = node;
        }
        size++;
    }

    public void deleteItem(T item){
        Node current = head;
        while(current != null){
            if(current.item == item){
                if(current == head){
                    head = current.next;
                    head.prev = null;
                }
                else if(current == back){
                    back = current.prev;
                    back.next = null;
                }
                else{
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }

    public void deleteIndice(int indice){
        if(indice <0 || indice >= size){
            if(size == 0){
                System.out.println("No item in the Linked List!!");
            }
            else{
                System.out.println("Please provide an indice from 0 to " + (size-1) );
            }
            return;
        }

        Node current = head;
        for(int i=0; i<indice ;i++){
            current = current.next;
        }

        if(current == head){
            head = current.next;
            head.prev = null;
        }
        else if(current == back){
            back = current.prev;
            back.next = null;
        }
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

    }

    public void printMyList(){
        Node current = head;
        while(current.next != null){
            System.out.print(current.item + " " + "<-> ");
            current = current.next;
        }
        System.out.print(current.item);
    }

    public int size(){
        return size;
    }



}
