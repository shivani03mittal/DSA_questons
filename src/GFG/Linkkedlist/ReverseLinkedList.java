package GFG.Linkkedlist;

public class ReverseLinkedList {
    class Node {
        int data;
        Node next;
        Node(int value) {
            this.data = value;
        }
    }


    class Solution
    {
        //Function to reverse a linked list.
        Node reverseList(Node head)
        {
            // code here
            if(head == null) return null;
            Node prev = null;
            Node curr = head;
            while(curr!= null){
                Node ahead = curr.next;
                curr.next = prev;
                prev= curr;
                curr= ahead;
            }

            return prev;

        }
    }

}
