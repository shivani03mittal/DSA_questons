package GFG.Linkkedlist;

public class DeleteAlternateNodes {
    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    class Solution {

        public void deleteAlternate (Node head){

            //Write your code here
            if(head == null || head.next==null) return;
            Node curr = head;
            while(curr!= null && curr.next !=null){
                curr.next = curr.next.next;
                curr= curr.next;
            }



        }
    }
}
