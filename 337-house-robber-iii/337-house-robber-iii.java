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
    Map<Integer, int[]> memo = new HashMap<>();
    
    public int rob(TreeNode root) {
        int[] canRob = helper(root, 0);
        return Math.max(canRob[0], canRob[1]);
    }
    
    int[] helper(TreeNode root, int id) {
        if (root == null) return new int[] {0, 0};
        
        if (memo.containsKey(id)) return memo.get(id);
        
        int[] lm = helper(root.left, id * 2 + 1);
        int[] rm = helper(root.right, id * 2 + 2);
        
        int[] max = new int[] {root.val + lm[1] + rm[1], Math.max(lm[0], lm[1]) + Math.max(rm[0], rm[1])};
        
        memo.put(id, max);
        
        return max;
    }
}