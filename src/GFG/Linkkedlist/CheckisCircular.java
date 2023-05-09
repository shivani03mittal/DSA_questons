package GFG.Linkkedlist;

public class CheckisCircular {

    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    class GfG
    {
        boolean isCircular(Node head)
        {
            // Your code here
            if (head == null)
                return true;

            Node node = head.next;
            while (node != null && node != head)
                node = node.next;


            return (node == head);

        }
    }
}
