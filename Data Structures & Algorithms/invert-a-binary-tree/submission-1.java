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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        if(root.left != null && root.right != null) {
            TreeNode leftTmp = root.left;
            TreeNode rightTmp = root.right;
            root.left = rightTmp;
            root.right = leftTmp;
            invert(root.left);
            invert(root.right);
        } else if(root.left != null) {
            root.right = root.left;
            root.left = null;
            invert(root.right);
        } else {
            root.left = root.right;
            root.right = null;
            invert(root.left);
        }
        
    }
}
