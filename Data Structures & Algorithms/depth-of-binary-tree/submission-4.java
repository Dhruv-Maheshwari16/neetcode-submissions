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
    int max_count = 0;
    int count = 0;

    public int maxDepth(TreeNode root) {
        if(root != null) {
            count = 1;
            max_count = 1;
        }
        depth(root);
        return max_count;
    }

    private void depth(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node.val + "->" + count);
        if(node.left != null || node.right != null) {
            count++;
        }
        else {
            return;
        }
        max_count = Math.max(count,max_count);
        depth(node.left);
        depth(node.right);
        count--;
    }
}
