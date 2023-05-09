package GFG.Linkkedlist;

public class linkedkistInsertion {



    class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

     //Function to insert a node at the beginning of the linked list.
        Node insertAtBeginning(Node head, int x)
        {

            Node nn = new Node(x);
            nn.next = head;
            head = nn;

            return head;
        }

        //Function to insert a node at the end of the linked list.
        Node insertAtEnd(Node head, int x)
        {
            // code here
            Node nn = new Node(x);

            if (head == null) {
                head = nn;
                return head;
            }

            Node last = getLastNode(head);
            last.next = nn;
            return head;

        }
    void display(Node head)
    {
        //add code here.
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }


        public static Node getLastNode(Node head)
        {

            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            return temp;
        }

        public static Node deleteFirst(Node head)
        {
             if(head==null)
             {
                 return null;
             }

             head = head.next;
             return head;
        }
        public static Node deletelast(Node head)
        {
            if(head==null)
            {
                return null;
            }
            if(head.next==null)  //case when only one noe present in ll
            {head= null; return head;}

            Node secondLast= head;
            Node last = head.next;
            while (last.next != null)
            {
                last= last.next;
                secondLast= secondLast.next;
            }
            secondLast.next= null;
            return head;
        }
//        count number of nodes// size of list
public static int getCount(Node head)
{

    //Code here
    int count=0;
    Node temp = head;
    while(temp != null)
    {
        count++;
        temp = temp.next;
    }

    return count;
}
    public static int getNth(Node head, int ind)
    {
        //Your code here
        Node temp =head;
        if(ind== 1)
        {
            return head.data;
        }

        for(int i=1;i< ind;i++)
        {
            temp = temp.next;
        }

        return temp.data;
    }
}
