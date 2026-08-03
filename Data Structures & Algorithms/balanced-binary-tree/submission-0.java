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
        int answer = dfs(root);
        return answer != -1;
    }

    int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == -1 || right == -1) {
            // indicate invalid
            return -1;
        }
        int diff = Math.abs(left - right);
        if(diff > 1) {
            //invalid 
            return -1;
        } else {
            //return the height
            return 1+ Math.max(left, right);
        }
    }
    
}


