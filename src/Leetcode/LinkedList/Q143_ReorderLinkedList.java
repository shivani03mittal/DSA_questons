package Leetcode.LinkedList;

public class Q143_ReorderLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null) return ;

            //find the mid
            //rverse after the mid
            //and then use two pointers from head and hed2
            //and then keep aaranginf

            ListNode mid = getmid(head);
            ListNode h2 = reverse(mid);
            ListNode h1= head;
            // ListNode h2 = mid.next;

            while(h1!= null && h2!= null){
                ListNode temp = h1.next;
                h1.next= h2;
                h1= temp;

                temp = h2.next;
                h2.next= h1;
                h2= temp;
            }

            if(h1 != null){
                h1.next= null;
            }
        }
        public ListNode getmid(ListNode head){

            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next!= null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public ListNode reverse(ListNode head){
            if(head== null) return head;
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null){
                ListNode ahead= curr.next;
                curr.next = prev;
                prev= curr;
                curr= ahead;
            }
            return prev;
        }
    }
}
