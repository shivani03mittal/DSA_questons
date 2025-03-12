package Leetcode.LinkedList;

public class Q148_ReverselistFromLeftTORight_notEntire {

     public class ListNode {
          int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left == right) return head;

            ListNode curr = head;
            ListNode prev = null;
            for(int i=0;curr != null && i< left-1;i++){
                prev= curr;
                curr= curr.next;
            }
            ListNode newEnd = curr;
            ListNode newprev= null;
            for(int k=0; curr != null && k< right -left +1;k++){
                ListNode ahead= curr.next;
                curr.next = newprev;
                newprev= curr;
                curr=ahead;
            }

            if(prev!= null){
                prev.next = newprev;
            }
            else{
                head= newprev;
            }
            newEnd.next = curr;
            return head;

        }
    }
}
