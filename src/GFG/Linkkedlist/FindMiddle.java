package GFG.Linkkedlist;

public class FindMiddle {
    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    class Solution
    {
        int getMiddle(Node head)
        {
            // Your code here.
            if(head == null )return -1;;
            if(head.next== null) return head.data;
            Node fast = head;
            Node slow  = head;
            while(fast!= null && fast.next!= null){
                fast= fast.next.next;
                slow= slow.next;
            }
            return slow.data;
        }
    }
}
