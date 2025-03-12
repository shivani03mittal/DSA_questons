package Leetcode.LinkedList;

public class Q25_Reverse_nodesin_kgroup_forloop {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(k<= 1 || head == null) return head;

            ListNode prev=null;
            ListNode curr = head;
            int size = getsize(head);
            int count = size/k;
            while(count>0){
                ListNode lastNode = prev;
                ListNode newEnd = curr;
                for(int i=0;curr!= null && i<k;i++){
                    ListNode ahead= curr.next;
                    curr.next= prev;
                    prev= curr;
                    curr= ahead;
                }
                if(lastNode !=null){
                    lastNode.next=prev;
                }else{
                    head = prev;
                }
                newEnd.next= curr;
                prev = newEnd;
                count--;
            }
            return head;
        }
        public int getsize(ListNode head){
            if(head==null) return 0;
            int ans=0;
            while(head!= null){
                ans ++;
                head= head.next;
            }
            return ans;
        }
    }
}
