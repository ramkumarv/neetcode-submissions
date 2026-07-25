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
        root = insertNodeInBSTRecursive(root, val);
        return root;
    }

    public TreeNode insertNodeInBSTRecursive(TreeNode root, int val) {
        //base case
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val < val) {
            root.right = insertNodeInBSTRecursive(root.right, val);
        } else if(root.val > val){
            root.left = insertNodeInBSTRecursive(root.left, val);    
        }
        //this is equal case which is not applicable here
        return root;
    }
    
    

}