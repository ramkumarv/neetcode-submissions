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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Step 1: BFS to collect nodes in level order
        List<TreeNode> order = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            order.add(node);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        // Step 2: process nodes in REVERSE order (deepest first)
        // so every node's children are already processed before the node itself
        Map<TreeNode, Integer> heightMap = new HashMap<>();

        for (int i = order.size() - 1; i >= 0; i--) {
            TreeNode node = order.get(i);
            int leftHeight = (node.left == null) ? 0 : heightMap.get(node.left);
            int rightHeight = (node.right == null) ? 0 : heightMap.get(node.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false; // imbalance found at this node
            }

            heightMap.put(node, 1 + Math.max(leftHeight, rightHeight));
        }

        return true;
    }
    
}


