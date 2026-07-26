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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        root = deleteNodeRecur( root, key); 
        return root;
    }

    private TreeNode deleteNodeRecur(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        //searching
        if(val > root.val) {
            //val gr than curr node val, so look in right side
            root.right = deleteNodeRecur(root.right, val);
            
        } else if(val < root.val) {
            //val is less so go left
            root.left = deleteNodeRecur(root.left, val);
            
        } else {
            //it found a matching node to delete
            if(root.left == null && root.right == null) {
                //left node, so return null so that we can remove the link
                return null;
            }
            if(root.left == null && root.right != null) {
                //the right node is not null, so simply remove this node and assign its right to the its parent
                return root.right;
            }
            if(root.left != null && root.right == null) {
                //the left node is not null, so simply remove this node and assign its left to the its parent
                return root.left;
            }
            if(root.left != null && root.right != null) {
                //this is the complex case, both nodes are not null, so find the min from its right
                TreeNode minNode = findMin(root.right);
                //replace the min val to root.val - swap
                root.val = minNode.val;
                //now the delete the original leaf  node. since we are finding min from the right child, we have to delete the right
                //also min or max node in a BST always be a leaf node so it should fall in a easy case(non recursive easy case) 
                root.right = deleteNodeRecur(root.right, root.val);
            }
        }
        return root;
    }

    TreeNode findMin(TreeNode root) {
        TreeNode min = root;
        while(root != null) {
            min = root;
            root = root.left;
        }
        return min;
    }

}