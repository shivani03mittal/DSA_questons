import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTrees{
        static int idx =-1;
        public static Node buildTree(int[] nodes){
            if(idx == nodes.length -1) return null;
            idx++;
            if(nodes[idx]== -1) return null;
            Node nn = new Node(nodes[idx]);
            nn.left = buildTree(nodes);
            nn.right= buildTree(nodes);

            return nn;
        }
    }
//traversal
    //O(n)
    public static void preOreder(Node root){
        if(root == null)
        {
           return;
        }

        System.out.print(root.data+" ");
        preOreder(root.left);
        preOreder(root.right);
    }

    public static void inOreder(Node root){
        if(root == null)
        {
            return;
        }


        inOreder(root.left);
        System.out.print(root.data+" ");
        inOreder(root.right);
    }
    public static void postOreder(Node root){
        if(root == null)
        {
            return;
        }


        postOreder(root.left);

        postOreder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root)
    {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty())
        {
            Node curr = q.remove();
            if(curr == null)
            {
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }

            }else {
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    q.add(curr.left);

                }
                if(curr.right!= null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
    int[] nodes={1,2,4,-1,-1,5,3,-1,6,-1,-1};
    BinaryTrees Bt = new BinaryTrees();
    Node root= Bt.buildTree(nodes);
        System.out.println(root.data);
        preOreder(root);
        System.out.println();
        inOreder(root);
        System.out.println();
        postOreder(root);
        System.out.println();
        levelOrder(root);
    }
}
