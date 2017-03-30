package Chapter2_LinkedLists.Q2_6;

import Chapter2_LinkedLists.MyLinkedList;

/**
 * Created by selimkonuk on 30/03/2017.
 */
public class Palindrome {
    public int size = 0;
    public int count = 0;
    public MyLinkedList.Node ptr;

    public boolean isPalindrome(MyLinkedList l){
        ptr = l.head;

        MyLinkedList.Node backptr = l.head;

        return helper(backptr);
    }

    public boolean helper(MyLinkedList.Node backptr){

        if(backptr == null){
            return true;
        }

        size++;

        boolean b = helper(backptr.next);

        count ++;
        if (b == false){
            return false;
        }
        if(count > size/2){
            return b;
        }

        if(ptr.item == backptr.item){
            ptr = ptr.next;
            return true;
        }
        return false;
    }



    public static void main(String args[]){
        Palindrome p = new Palindrome();

        MyLinkedList l = new MyLinkedList();
        l.addLast("b");
        l.addLast("a");
        l.addLast("r");
        l.addLast("r");
        l.addLast("a");
        l.addLast("b");

        System.out.println(p.isPalindrome(l));
    }

}


