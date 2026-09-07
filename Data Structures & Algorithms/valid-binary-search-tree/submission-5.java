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
    public boolean isValidBST(TreeNode root) {
        //return isValidTopDown(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
        List<Integer> sortedList = new ArrayList<>();
        inOrder(root, sortedList);

        int lastVal = sortedList.get(0);
        for(int i=1; i < sortedList.size(); i++){
            if(sortedList.get(i) <= lastVal) {
                return false;
            }
            lastVal = sortedList.get(i);
        }
        return true;
    }

    void inOrder(TreeNode root, List<Integer> sortedList) {
        if(root == null) {
            return;
        }
        inOrder(root.left, sortedList);
        sortedList.add(root.val);
        inOrder(root.right, sortedList);

    }
    


    boolean isValidTopDown(int leftMin, TreeNode root, int rightMax) {
        if(root == null) {
            return true;
        }
        
        if(root.val <= leftMin || root.val >= rightMax)  {
            return false;
        }

        boolean left = isValidTopDown(leftMin, root.left, root.val);
        boolean right = isValidTopDown(root.val, root.right, rightMax);
        
        return left && right;
    }

    
}

class Result {
    public int left;
    public int right;
    public boolean result;
    Result(int left, int right, boolean result) {
        this.left = left;
        this.right = right;
        this.result = result;
    }
}

