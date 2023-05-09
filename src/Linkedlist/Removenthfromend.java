package Linkedlist;

public class Removenthfromend {

//     * Definition for singly-linked list.
      public class ListNode {
        int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next == null)
                return null;

            int size =0;
            ListNode temp = head;
            while(temp != null){
                size++;
                temp = temp.next;
            }
            int idx = size - n;
            if(size == n)
            {
                return head.next;
            }
            temp = head;
            int i=1;
            while(i< idx){
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;

            return head;
        }
    }
}
