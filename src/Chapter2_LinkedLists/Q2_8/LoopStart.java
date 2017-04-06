package Chapter2_LinkedLists.Q2_8;

import Chapter2_LinkedLists.Q2_7.NodeClass;

/**
 * Created by selimkonuk on 06/04/2017.
 */
public class LoopStart {


    public NodeClass findFirstElementLoop(NodeClass n){

        NodeClass slow = n;
        NodeClass fast = n;

        while(true){

            if(fast == null || fast.next == null){
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        slow = n;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

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

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n4;

        LoopStart ls = new LoopStart();
        NodeClass val = ls.findFirstElementLoop(n1);

        if(val == null){
            System.out.println("No loop!!");
        }
        else{
            System.out.println(val.item);
        }

    }
}
