package Linkedlist;

public class ll_basics {
    static class Node{
        String data;
        Node next;

        public Node(String data){
            this.data= data;
            this.next= null;
        }
    }
    Node head;
    public void addFirst(String data)
    {
        Node nn = new Node(data);
        if(head== null){
            head = nn;
            return ;
        }
        nn.next= head;
        head = nn;

    }
    public  void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" >>");
            temp = temp.next;
        }
        System.out.print("nulll");
        return;
    }

    public void reverseIterative()
    {
//        if 0 or 1 node
        if(head== null || head.next == null) return;

        Node prevNode= head;
        Node currNode = head.next;
        while (currNode != null){
            Node nextNode = currNode.next;
            currNode.next= prevNode;

//            update
            prevNode= currNode;
            currNode = nextNode;
        }

//        remove the very forst link
        head.next= null;
        head= prevNode;
    }

    public Node reverseRecutrsive(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        Node newNode= reverseRecutrsive(head.next);
        head.next.next= head;
        head.next= null;

        return  newNode;
    }
    public static void main(String[] args) {
        ll_basics ll = new ll_basics();
        ll.addFirst("a");
        ll.addFirst("is");
        ll.addFirst("this");
        ll.display();
        ll.reverseIterative();
        System.out.println();
        ll.display();
        System.out.println();
       ll.head= ll.reverseRecutrsive(ll.head);
       ll.display();
    }
}
