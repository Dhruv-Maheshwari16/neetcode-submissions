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
    TreeNode res;

    public TreeNode invertTree(TreeNode root) {
        res = root;
        invert(res);
        return res;
    }

    private void invert(TreeNode node) {
        if(node == null) {
            return;
        }

        invert(node.left);
        invert(node.right);
        
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
    }
}
