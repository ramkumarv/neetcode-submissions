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

class Solution {
    public int maxDepth(TreeNode root) {
        //return maxDepthTopDownDFS(root);
        return maxDepthBottomUpDFS(root);

    }

    
    int maxDepthBottomUpDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftTreeDepth = maxDepthBottomUpDFS(root.left);
        int rightTreeDepth = maxDepthBottomUpDFS(root.right);
        return 1 + Math.max(leftTreeDepth, rightTreeDepth);
    }
}
