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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    
    void helper(TreeNode root, List<Integer> result, int i) {
        if (root == null) return;
        
        if (result.size() == i) result.add(root.val);
        
        helper(root.right, result, i + 1);
        helper(root.left, result, i + 1);
    }
}