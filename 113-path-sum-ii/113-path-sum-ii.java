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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, targetSum, new LinkedList<>(), res);
        return res;
    }
    
    void helper(TreeNode root, int targetSum, LinkedList<Integer> current, List<List<Integer>> res) {
        targetSum -= root.val;
        
        current.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (targetSum == 0) res.add(List.copyOf(current));
        } else {
            if (root.left != null) helper(root.left, targetSum, current, res);
            if (root.right != null) helper(root.right, targetSum, current, res);
        }
        
        current.removeLast();
    }
}