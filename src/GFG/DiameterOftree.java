//package GFG;
//
//public class DiameterOftree {
//    int diameter(Node root) {
//        // Your code here
//        if(root == null)
//        {
//            return 0;
//
//        }
//
//        int dia1 = diameter(root.left);
//        int dia2= diameter(root.right);
//        int dia3= height(root.left)+ height(root.right)+1;
//
//        return Math.max(dia3, Math.max(dia1, dia2));
//
//
//    }
//    int height(Node root)
//    {
//        if(root == null)
//        {
//            return 0;
//        }
//
//        int left = height(root.left);
//        int right= height(root.right);
//        int h = Math.max(left, right) +1;
//
//        return h;
//    }
//}
