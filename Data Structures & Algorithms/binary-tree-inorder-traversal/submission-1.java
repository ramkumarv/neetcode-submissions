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
        inOrderIterative(root, values);
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

    void inOrderIterative(TreeNode root, List<Integer> values) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // curr is null, pop from stack
            curr = stack.pop();
            
            // Process the node (this is the "visit" in inorder)
            values.add(curr.val);
            
            // Visit the right subtree
            curr = curr.right;
        }
    }

    
}