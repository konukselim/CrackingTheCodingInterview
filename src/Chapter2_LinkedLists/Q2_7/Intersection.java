package Chapter2_LinkedLists.Q2_7;

import Chapter2_LinkedLists.MyLinkedList;

import static Chapter2_LinkedLists.MyLinkedList.*;

/**
 * Created by selimkonuk on 30/03/2017.
 */
public class Intersection {

    public NodeClass intersection(NodeClass node1, NodeClass node2){
        NodeClass longlist = node1;
        NodeClass shortlist = node2;
        int difference = 0;

        NodeClass ptr1 = node1;
        NodeClass ptr2 = node2;

        while(ptr1 != null || ptr2 != null){
            if(ptr1 == null){
                difference++;
                ptr2 = ptr2.next;
                longlist = node2;
                shortlist = node1;
            }
            else if(ptr2 == null){
                difference++;
                ptr1 = ptr1.next;
            }
            else{
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;

            }
        }

        while(difference > 0){
            longlist = longlist.next;
            difference--;
        }

        while(longlist != null){
            if(longlist == shortlist){
                return longlist;
            }
            longlist = longlist.next;
            shortlist = shortlist.next;
        }
        return null;
    }


    public static void main(String args[]){

        NodeClass n1 = new NodeClass();
        n1.item = "n1";
        NodeClass n2 = new NodeClass();
        n2.item = "n2";
        NodeClass n3 = new NodeClass();
        n3.item = "n3";
        NodeClass n4 = new NodeClass();
        n4.item = "n4";
        NodeClass n5 = new NodeClass();
        n5.item = "n5";
        NodeClass n6 = new NodeClass();
        n6.item = "n6";
        NodeClass n7 = new NodeClass();
        n7.item = "n7";
        NodeClass n8 = new NodeClass();
        n8.item = "n8";
        NodeClass n9 = new NodeClass();
        n9.item = "n9";
        NodeClass n10 = new NodeClass();
        n10.item = "n10";
        NodeClass n11 = new NodeClass();
        n11.item = "n11";

        n1.next = n2;
        n2.next = n7;

        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = null;

        Intersection i = new Intersection();
        NodeClass n = i.intersection(null, null);

        if(n != null){
            System.out.println(n.item);
        }
        else{
            System.out.println("null");
        }


    }
}
