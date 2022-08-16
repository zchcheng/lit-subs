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
    TreeNode result = null;
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root, 0, k);
        return result.val;
    }
    
    int[] helper(TreeNode root, int current, int k) {
        if (root == null) return new int[] { current, -1 };
        int[] res = helper(root.left, current, k);
        if (res[1] == 1) return new int[] { -1, 1 };
        current = res[0] + 1;
        if (current == k) {
            result = root;
            return new int[] {-1, 1};
        }
        return helper(root.right, current, k);
    }
}