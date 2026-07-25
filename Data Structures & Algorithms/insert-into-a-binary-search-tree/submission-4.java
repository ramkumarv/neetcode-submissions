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
        //root = insertNodeInBSTRecursive(root, val);
        root = insertNodeIterativelyInBST(root, val);
        return root;
    }

    public TreeNode insertNodeIterativelyInBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        boolean inserted = false;
        while(!inserted) {
            if(curr.val > val ) {
                if(curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    inserted = true;  
                }   
            } else {
                if(curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    inserted = true;  
                }        
            }

        }

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