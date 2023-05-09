package Linkedlist;

public class PlaindromeLL {

//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
          }


        public ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null)
            {
                ListNode next = curr.next;
                curr.next = prev;

                prev= curr;
                curr = next;
            }

            return prev;
        }

        public ListNode findMid(ListNode head){
            ListNode hare = head;
            ListNode tt= head;
            while(hare.next != null && hare.next.next != null)
            {
                hare = hare.next.next;
                tt = tt.next;
            }
            return tt;
        }
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null ) return true;

            ListNode mid= findMid(head);
            ListNode secondHead = reverse(mid.next);
            ListNode firstHead = head;
            while(secondHead != null)
            {
                // System.out.println(secondHead.val+" "+ firstHead.val);
                if(firstHead.val != secondHead.val) {
                    return false;
                }

                firstHead = firstHead.next;
                secondHead= secondHead.next;

            }

            return true;
        }

}
