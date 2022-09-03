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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> pathSum = new HashMap<>();
        return helper(root, targetSum, pathSum, 0);
    }
    
    int helper(TreeNode root, long target, Map<Long, Integer> pathSum, long current) {
        if (root == null) return 0;
        
        long sum = current + root.val;
        int self = ((sum == target)? 1 : 0) + pathSum.getOrDefault(sum - target, 0);
        
        pathSum.put(sum, pathSum.getOrDefault(sum, 0) + 1);
        
        int res = self + helper(root.left, target, pathSum, sum) + helper(root.right, target, pathSum, sum);
        
        pathSum.put(sum, pathSum.getOrDefault(sum, 0) - 1);
        
        return res;
    }
}