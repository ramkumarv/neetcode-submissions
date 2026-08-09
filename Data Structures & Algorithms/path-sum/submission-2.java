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
    boolean isFound = false;
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        hasPathSumRecursive(root, targetSum, 0);
        return isFound;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return hasPathSumRecur(root, targetSum, 0);
    }

    boolean hasPathSumRecur(TreeNode root, int targetSum, int curSum) {
        if(root == null) {
            return false;
        }
        if(isLeafNode(root)) {
            isFound = ((root.val + curSum) == targetSum);
            return isFound;
        }
        
        if(!isFound && hasPathSumRecur(root.left, targetSum, curSum+root.val)) {
            return true;
        }
        if(!isFound && hasPathSumRecur(root.right, targetSum, curSum+root.val)) {
            return true;
        }
        return false;
    }

    boolean isLeafNode(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    private boolean hasPathSumRecursive(TreeNode root, int targetSum, int curSum) {
        if(curSum == targetSum && root == null) {
            isFound = true;
            return true;
        }
        if(root == null) {
            return false;
        }
        if(isFound) {
            return true;
        }

        hasPathSumRecursive(root.left, targetSum, curSum+root.val);
        hasPathSumRecursive(root.right, targetSum, curSum+root.val);
        return false;
    }
}