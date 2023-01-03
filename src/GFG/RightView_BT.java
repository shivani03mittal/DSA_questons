//package GFG;
//
//
//
//import java.util.ArrayList;
//
//public class RightView_BT {
//    class Solution{
//        //Function to return list containing elements of right view of binary tree.
//        ArrayList<Integer> rightView(Node node) {
//            //add code here.
//            ArrayList<Integer> arr= new ArrayList<>();
//            if(node == null)
//                return arr;
//            right(node, arr, 0);
//
//            return arr;
//
//        }
//
//        public static void right(Node root, ArrayList<Integer> arr, int level)
//        {
//            if(root == null)
//                return;
//
//            if(level == arr.size())
//                arr.add(root.data);
//
//            right(root.right, arr, level+1);
//            right(root.left,arr,level+1);
//        }
//    }
//
//}
