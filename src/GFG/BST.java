package GFG;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BST {
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int data){
            val=data;
        }
    }

    public static Node insert(Node root,int x){

        if(root==null){
            root = new Node(x);
            return root;
        }
        if(root.val > x){
            root.left= insert(root.left,x);
        }else{
            root.right= insert(root.right,x);
        }
        return root;

    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null)
            return false;
        if(root.val> key){
            return search(root.left,key);
        }
        else if(root.val==key){
            return true;

        }
        else {
            return search(root.right,key);
        }

    }

    //delete a node
    public static Node delete(Node root, int val){
        //first search the root with key to be deleted
        if(root.val> val){
            root.left= delete(root.left, val);

        }else if(root.val< val){
            root.right= delete(root.right, val);
        }
        else {//root == val

            //deletion
            //cse1: no child
            if (root.left == null && root.right == null) {
                return null;
            }

            //case2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //case 3>>> first find inorder successor, and replace the value and delete the value of IS from right subtree
            Node inOrderSucc = inorderSucc(root.right);
            root.val = inOrderSucc.val;
            delete(root.right, inOrderSucc.val);

        }
            return root;

    }

    public static Node inorderSucc(Node root){
        while(root.left != null){
            root=root.left;
        }
        return root;
    }

    public static void printInRage(Node root, int x, int y){
        if(root==null){
            return;
        }
        //case 1 x<= root.val<= y
        if(root.val>= x && root.val<= y){
            printInRage(root.left,x,y);
            System.out.print(root.val);
            printInRage(root.right,x,y);
        }
        //cas2: root.val>=y
        else if(root.val>=y){
            printInRage(root.left,x,y);
        }
        //case3: root.data<= x
        else{
            printInRage(root.right,x,y);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i : path){
            System.out.print(i);

        }
        System.out.println();
    }
    // printpathtoleaf
    public static void printToLeafNode(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        //if leafnode


        path.add(root.val);
        if(root.left== null && root.right==null){
            printPath(path);
        }
        else {
            printToLeafNode(root.left, path);
            printToLeafNode(root.right, path);
        }
        path.remove(path.size()-1); //backtracking


    }
    public static void main(String[] args) {
        int[] arr= {5,3,4,2,1,6,7};
        Node root = null;
        for (int i = 0;i< arr.length;i++){
            root = insert(root,arr[i]);
        }
        inorder(root);
        System.out.println();
        if(search(root,3)){
            System.out.println("found");
        }else
            System.out.println("not found");
        if(search(root,8)){
            System.out.println("found");
        }else
            System.out.println("not found");

        delete(root,4);
        inorder(root);

        System.out.println();
        printInRage(root,3,12);
        System.out.println();
        printToLeafNode(root, new ArrayList<Integer>());
    }
}
