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
        AtomicInteger depth = new AtomicInteger(0);
        maxDepthTopDownDFS(root, 1, depth);
        return depth.get();
        //return maxDepthBottomUpDFS(root);

    }

    void maxDepthTopDownDFS(TreeNode root, int currentDepth, AtomicInteger maxDepth) {
        if(root == null) {
            return;
        }
        if(currentDepth > maxDepth.get()) {
            maxDepth.set(currentDepth);
        }
        maxDepthTopDownDFS(root.left, currentDepth+1, maxDepth);
        maxDepthTopDownDFS(root.right, currentDepth+1, maxDepth);

    }


    //why bottomup - once you reach the leaf node, the depth getting computed on the way back up
    int maxDepthBottomUpDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftTreeDepth = maxDepthBottomUpDFS(root.left);
        int rightTreeDepth = maxDepthBottomUpDFS(root.right);
        return 1 + Math.max(leftTreeDepth, rightTreeDepth);
    }
}
