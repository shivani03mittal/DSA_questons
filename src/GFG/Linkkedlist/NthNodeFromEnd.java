package GFG.Linkkedlist;

public class NthNodeFromEnd {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }



    class GfG
    {
        //Function to find the data of nth node from the end of a linked list.
        int getNthFromLast(Node head, int n)
        {
            // Your code here
            if(head == null) return -1;
            int lenght = count(head);
            if(lenght -n <0) return -1;
            for(int i=1; i<= lenght - n ;i++ ){
                head = head.next;
            }
            return head.data;
        }
        int count(Node head){
            int c=0;
            while(head!= null){
                c++;
                head=head.next;
            }
            return c;
        }
    }

}
