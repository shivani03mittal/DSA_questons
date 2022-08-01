//package GFG;
//
//public class MInValueBST {
//    int minValue(Node node) {
//        // bst so min at left only
//        if(node == null)
//        {
//            return -1;
//        }
//        Node current = node;
//        while(current.left != null)
//        {
//            current= current.left;
//        }
//
//        return current.data;
//    }
//}
