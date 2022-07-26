//package GFG;
//
//import java.util.ArrayList;
//
//public class InorderTraverese {
//    ArrayList<Integer> inOrder(Node root) {
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//
//        inorderT(root, ans);
//        return ans;
//        // Code
//    }
//
//    public static void inorderT(Node root,ArrayList<Integer> ans )
//    {
//        if(root == null)
//        {
//            return ;
//        }
//
//
//        inorderT(root.left, ans);
//        ans.add(root.data);
//        inorderT(root.right, ans);
//
//
//    }
//}
