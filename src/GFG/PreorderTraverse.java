package GFG;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class PreorderTraverse {
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        preordertraverse(root, ans);

        return ans;
    }

    public static void preordertraverse(Node root, ArrayList<Integer> ans)
    {
        if(root == null)
        {
            return ;
        }

//        ans.add(root.data);
//        preordertraverse(root.left, ans);
//        preordertraverse(root.right, ans);
    }
}
