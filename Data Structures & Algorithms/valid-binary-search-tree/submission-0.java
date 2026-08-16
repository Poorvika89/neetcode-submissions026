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
        return validateBST(root, null, null);
            }

                private boolean validateBST(TreeNode node, Integer lower, Integer upper) {
                        if (node == null) return true;
                                if (lower != null && node.val <= lower) return false;
                                        if (upper != null && node.val >= upper) return false;
                                                return validateBST(node.left, lower, node.val) && validateBST(node.right, node.val, upper);
    }
}
