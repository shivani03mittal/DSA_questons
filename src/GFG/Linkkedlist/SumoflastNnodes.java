package GFG.Linkkedlist;

public class SumoflastNnodes {

//Node class is as follows:

class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}


    class Solution {

        //Return the sum of last k nodes
        public int sum(Node head, int k){
            //write code here
            //first move till that desired position of node
            if(head == null) return 0;
            if(k==0 ) return 0;
            int n =0;
            Node temp = head;
            while(temp != null){
                n++;
                temp = temp.next;
            }
            //   if(k == n) return head.data;

            for(int i=0; i< n-k;i++){
                head= head.next;
            }
            int sum =0;
            while(head != null && k >0){
                sum += head.data;
                k--;
                head= head.next;
            }

            return sum;

        }
    }
}
