package Chapter2_LinkedLists.Q2_5;

import Chapter2_LinkedLists.MyLinkedList;

/**
 * Created by selimkonuk on 19/03/2017.
 */
public class SumLists {


    public MyLinkedList reverseOrder(MyLinkedList ll , MyLinkedList rl){
        MyLinkedList.Node lhead = ll.head;
        MyLinkedList.Node rhead = rl.head;
        MyLinkedList summedList = new MyLinkedList();

        boolean carry = false;

        while(true){
            int sum = 0;

            if(lhead != null && rhead != null){
                sum = (int) lhead.item + (int) rhead.item;
                lhead = lhead.next;
                rhead = rhead.next;
            }
            else if(lhead != null){
                sum = (int) lhead.item;
                lhead = lhead.next;

            }
            else if(rhead != null){
                sum = (int) rhead.item;
                rhead = rhead.next;
            }
            else{
                break;
            }

            if(carry){
                sum += 1;
            }
            carry = false;
            if(sum >= 10){
                carry = true;
                sum -= 10;
            }

            summedList.addLast(sum);

        }

        if(carry){
            summedList.addLast(1);
        }

        return summedList;

    }

    public MyLinkedList forwardOrder(MyLinkedList ll , MyLinkedList rl){

        MyLinkedList.Node lhead = ll.head;
        MyLinkedList.Node rhead = rl.head;

        while(lhead != null || rhead != null){
            if(lhead == null){
                ll.addFirst(0);
                rhead = rhead.next;
            }
            else if(rhead == null){
                rl.addFirst(0);
                lhead = lhead.next;
            }
            else{
                rhead = rhead.next;
                lhead = lhead.next;
            }
        }

        MyLinkedList summedlist = new MyLinkedList();
        lhead = ll.head;
        rhead = rl.head;
        boolean iscarry = recursiveSum(lhead , rhead, summedlist);
        if(iscarry){
            summedlist.addFirst(1);
        }

        return summedlist;
    }

    public boolean recursiveSum(MyLinkedList.Node ln, MyLinkedList.Node rn , MyLinkedList sum){

        if(ln == null && rn == null){
            return false;
        }

        boolean carry = recursiveSum(ln.next, rn.next , sum);

        int s = (int) ln.item + (int) rn.item;
        if(carry){
            s += 1;
        }
        carry = false;
        if(s >= 10){
            carry = true;
            s -= 10;
        }
        sum.addFirst(s);
        return carry;

    }

    public static void main(String args[]){
        MyLinkedList l = new MyLinkedList();
        l.addLast(9);
        l.addLast(7);
        l.addLast(8);
        MyLinkedList r = new MyLinkedList();
        r.addLast(6);
        r.addLast(8);
        r.addLast(5);


        SumLists s = new SumLists();

        s.reverseOrder(l,r).printMyList();
        System.out.println();

        MyLinkedList sum = new MyLinkedList();
        sum = s.forwardOrder(l , r);
        sum.printMyList();
    }
}
