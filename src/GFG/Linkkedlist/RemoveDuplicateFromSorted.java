package GFG.Linkkedlist;

public class RemoveDuplicateFromSorted {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    class GfG
    {
        //Function to remove duplicates from sorted linked list.
        Node removeDuplicates(Node head)
        {
            // Your code here
            Node curr = head;
            if(head==null)return null;
            while(curr != null )
            {
                while( curr.next != null &&curr.data == curr.next.data)
                    curr.next = curr.next.next;

                curr= curr.next;
            }

            return head;
        }
    }
}
