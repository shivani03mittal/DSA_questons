package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTravesal_102 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            List<List<Integer>> ans = new ArrayList<>();
//            Queue<TreeNode> q= new LinkedList<TreeNode>();
//            if(root == null)
//                return ans;
//            q.add(root);
//            while(!q.isEmpty())
//            {
//                int len = q.size();
//                List<Integer> row = new ArrayList<>();
//                for(int i=0;i<len;i++)
//                {
//                    TreeNode nn = q.poll();
//                    row.add(nn.val);
//
//                    if(nn.left!= null)
//                        q.add(nn.left);
//                    if(nn.right!=null)
//                        q.add(nn.right);
//                }
//                ans.add(row);
//            }
//            return ans;
//        }
//    }
}
