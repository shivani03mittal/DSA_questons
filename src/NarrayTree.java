import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NarrayTree {
    static class Node{
        int data;
        ArrayList<Node> children ;

        public Node(int data){
            this.data = data;
            this.children=  new ArrayList<>();
        }

    }
    public static Node createNtree(int[] nodes, Stack<Node> s)
    {
        Node root= null;
        for(int i =0 ;i< nodes.length;i++)
        {
            if(nodes[i]==-1 && ! s.isEmpty())
                s.pop();
            else {
                Node t= new Node(nodes[i]);
                if(s.size()>0)
                    s.peek().children.add(t);
                else
                    root = t;
                s.push(t);
            }
        }
    return root;
    }
    public static void displayTree(Node root){
//        print slef
//        call display for all children
        if(root == null)
            return;
        System.out.print(root.data+" >");
        for (Node child: root.children)
        {
            System.out.print(child.data+" >");
        }
        System.out.println();

        for (Node child : root.children)
            displayTree(child);
    }

//    size of tree
    public static int size(Node root){
        int s =0;
        if(root == null) return s;
//        size = 1+ size of child /subtree
        for(Node child : root.children)
        {
            int cs = size(child);
            s = s+ cs;
        }
        s +=1;
        return s;
    }

//    maximum node from tree
    public static int maxNode(Node root){
        if(root == null) return  root.data;
        int max = Integer.MIN_VALUE;
//        max = max(root, and subtree)
        for(Node child: root.children)
        {
            int max_temp = maxNode(child);
            if(max_temp > max)
                max = max_temp;
        }
        if(root.data > max)
            max= root.data;

        return max;
    }

//    height of tree
    public static int height(Node root){
        if(root== null) return 0;
        int ht = -1; // because if no childrwn then ht =0;
        for(Node child : root.children)
        {
            int ch = height(child);
             ht = Math.max(ht, ch);

        }
        ht = ht +1; // addind the edge from root

        return ht;
    }
//    pre order traversal
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        for (Node child : root.children)
        {
            preOrder(child);
        }
    }

    public static void postOrder(Node root){
        if(root == null) return;

        for (Node child : root.children)
        {
            postOrder(child);
        }
        System.out.print(root.data+" ");
    }

    public static void  levelorder(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            Node t = q.remove();
            System.out.print(t.data+" ");
            for(Node child: t.children)
            {
                q.add(child);
            }

        }
        System.out.println();
    }
    public static void main(String[] args) {
    int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    Stack<Node> s = new Stack<>();
    Node root = createNtree(arr,s);
//        System.out.println(root.data);
//        for (Node r : root.children)
//            System.out.print(r.data+" ");

//        System.out.println("-------------------------");
//        displayTree(root);
//
//        System.out.println();
//        System.out.println(size(root));
//
//        System.out.println("max===========");
//        System.out.println(maxNode(root));
//
//        System.out.println("height = :" + height(root));
//        System.out.println("preorder: " );
//        preOrder(root);
//        postOrder(root);
        levelorder(root);
    }
}
