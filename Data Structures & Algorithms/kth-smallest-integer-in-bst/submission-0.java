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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> orderedList = new ArrayList<>();
        inOrderTraversal(root, orderedList);
        return orderedList.get(k-1);
    }

    void inOrderTraversal(TreeNode root, List<Integer> orderedList) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, orderedList);
        orderedList.add(root.val);
        inOrderTraversal(root.right, orderedList);
    }

    
}
