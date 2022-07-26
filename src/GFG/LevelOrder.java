//package GFG;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//public class LevelOrder {
//    static ArrayList<Integer> levelOrder(Node root)
//    {
//        // Your code here
//        ArrayList<Integer> ans = new ArrayList<>();
//        if(root== null)
//            return ans;
//        level(root, ans);
//        return ans;
//    }
//
//    public static void level(Node root, ArrayList<Integer> ans)
//    {
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        q.add(null);
//
//        while(!q.isEmpty())
//        {
//            Node curr= q.remove();
//            if(curr == null)
//            {
//                if(q.isEmpty())
//                    break;
//                else
//                {
//                    q.add(null);
//                }
//            }
//            else
//            {
//                ans.add(curr.data);
//                if(curr.left != null)
//                {
//                    q.add(curr.left);
//                }
//                if(curr.right != null)
//                {
//                    q.add(curr.right);
//                }
//            }
//        }
//
//    }
//}
