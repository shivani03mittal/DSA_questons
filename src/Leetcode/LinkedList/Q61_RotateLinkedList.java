package Leetcode.LinkedList;

public class Q61_RotateLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(k<= 0 || head== null|| head.next==null) return head;

            //get last node make its next = originalhead;
            //get the node from where rotation will have make it newHaed
            //node before the start of sublist

            //getlength
            ListNode lastNode = head;
            int l=1;
            while(lastNode.next!=null){
                l++;
                lastNode= lastNode.next;
            }

            //make lastnode's next as head'
            lastNode.next= head;

            ListNode newLastNode = head;
            int rotation = k%l;
            int skips= l-rotation;
            for(int i=0;i<skips -1 ;i++){
                newLastNode= newLastNode.next;
            }
            head= newLastNode.next;
            newLastNode.next= null;

            return head;


        }
    }
}
