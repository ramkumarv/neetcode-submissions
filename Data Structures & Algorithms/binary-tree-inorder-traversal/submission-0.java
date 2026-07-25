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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderRecursive(root, values);
        return values;
    }

    void inOrderRecursive(TreeNode root, List<Integer> values) {
        if(root == null) {
            return;
        }
        inOrderRecursive(root.left, values);
        values.add(root.val);
        inOrderRecursive(root.right, values);
    }
}