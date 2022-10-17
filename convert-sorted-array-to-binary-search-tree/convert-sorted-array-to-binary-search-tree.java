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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    TreeNode helper(int[] nums, int s, int e) {
        if (s > e) return null;
        
        int m = s + (e - s) / 2;
        
        TreeNode node = new TreeNode(nums[m]);
        
        node.left = helper(nums, s, m - 1);
        node.right = helper(nums, m + 1, e);
        
        return node;
    }
}