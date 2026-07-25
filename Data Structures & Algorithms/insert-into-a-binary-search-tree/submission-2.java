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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertRec(root, val);
    }
    
    TreeNode insertRec(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val, null, null);
        }
        if(val > root.val) {
            root.right = insertRec(root.right, val);  
            return root;
        } else if(val < root.val) {
            root.left = insertRec(root.left, val);  
            return root;
        } 
        return root;
    }

}