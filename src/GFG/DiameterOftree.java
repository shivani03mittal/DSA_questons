//package GFG;
//
//public class DiameterOftree {
/*
* case1: through root
* case2: does not pass through root*/
//o(n2) if height not  used at time of dia


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
//
//class Treeinfo{
//    int ht ;
//    int dia;
//
//    Treeinfo(int ht, int dia){
//        this.ht = ht;
//        this.dia= dia;
//    }
//}
//
//public Treeinfo diameter2(Node root){
// if(root == null)
// return new Treinfo(0,0);
//
//    Treeinfo left = diameter2(root.left);
//    Treeinfo right = diameter2(root.right);
//
//    int myheight = Math.max(left.ht, right.ht) +1;
//    int dia1 = left.dia;
//    int dia2= right.dia;
//    int dia3 = left.ht+ right.ht+1;
//
//    int mydia = Math.max(dia1, Math.max(dia2, dia3));
//    Treeinfo myinfo = new Treeinfo(myheight, mydia);
//    return myinfo;
//}
//}
