package Linkedlist;

public class NodeOfCyclic {


//      Definition for singly-linked list.

      class ListNode {

          int val;

          ListNode next;

          ListNode(int x) {

              val = x;

              next = null;

          }

      }


    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode h = head;
            ListNode t = head;
            if(head == null || head.next == null  || h.next.next == null ) return null;

            while(h.next != null && h.next.next != null){
                h = h.next.next;
                t =t.next;

                if(h == t)break;
            }
            t = head;
            while(h != null && h.next != null){
                if(h == t) return h;
                h = h.next;
                t =t.next;


            }

            return null;
        }
    }
}
