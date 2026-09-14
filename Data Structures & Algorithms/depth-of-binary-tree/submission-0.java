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
        return maxDepthTopDownDFS(root);
    }

    int maxDepthTopDownDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftTreeDepth = maxDepthTopDownDFS(root.left);
        int rightTreeDepth = maxDepthTopDownDFS(root.right);
        return 1 + Math.max(leftTreeDepth, rightTreeDepth);
    }
}
