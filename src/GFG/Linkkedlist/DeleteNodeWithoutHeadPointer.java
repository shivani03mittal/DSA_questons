package GFG.Linkkedlist;

public class DeleteNodeWithoutHeadPointer {
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    //Function to delete a node without any reference to head pointer.
    class Solution
    {
        void deleteNode(Node del)
        {
            // Your code here
            if(del == null || del.next == null ) return;
            del.data = del.next.data;
            del.next= del.next.next;

        }
    }
}
