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
    Map<Integer, long[]> map = new HashMap<>();
    long res = 0;
        
    public int widthOfBinaryTree(TreeNode root) {
        helper(root, 1, 0);
        return (int)res;
    }
    
    void helper(TreeNode root, long offset, int lvl) {
        if (root == null) return;
        
        long[] b = map.computeIfAbsent(lvl, k -> new long[] {offset, offset});
        b[0] = Math.min(b[0], offset);
        b[1] = Math.max(b[1], offset);
        
        res = Math.max(res, b[1] - b[0] + 1);
        
        helper(root.left, 2 * offset - 1, lvl + 1);
        helper(root.right, 2 * offset, lvl + 1);
    }
}