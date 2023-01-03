package Leetcode.LinkedList;

public class Merge_two_sortedlists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
//    class Solution {
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
////         make a dummy node and keep adding the poiners to the next cooming nide into it.
//            ListNode p1 = list1;
//            ListNode p2 = list2;
//            ListNode dummyNode= new ListNode(-1);
//            ListNode p3  = dummyNode;
//
//            while(p1!= null && p2 != null)
//            {
//                if(p1.val >= p2.val)
//                {
//                    p3.next = p2;
//                    p2= p2.next;
//                }
//
//                else
//                {
//                    p3.next = p1;
//                    p1= p1.next;
//                }
//
//                p3= p3.next;
//            }
//
////         if any one list ends
//            while(p1 != null){
//                p3.next = p1;
//                p1= p1.next;
//                p3= p3.next;
//            }
//
//            while(p2 != null){
//                p3.next = p2;
//                p2= p2.next;
//                p3= p3.next;
//            }
//
//
//            return dummyNode.next;
//        }
//    }
}
