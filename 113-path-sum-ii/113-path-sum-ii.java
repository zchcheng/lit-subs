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
        return dfs(root, targetSum);
    }
    
    List<List<Integer>> dfs(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root != null) dfsHelper(root, targetSum, new ArrayList<>(), result);
        
        return result;
    }
    
    void dfsHelper(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        current.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (root.val == sum) result.add(List.copyOf(current));
            current.remove(current.size() - 1);
            return;
        }
        
        if (root.left != null) dfsHelper(root.left, sum - root.val, current, result);
        if (root.right != null) dfsHelper(root.right, sum - root.val, current, result);
        
        current.remove(current.size() - 1);
    }
}