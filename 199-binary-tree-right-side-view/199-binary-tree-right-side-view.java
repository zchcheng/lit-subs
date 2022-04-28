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
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return res;
    }
    
    void helper(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        
        if (res.size() <= d) {
            res.add(-1);
        }
        
        res.set(d, root.val);
        
        helper(root.left, d + 1);
        helper(root.right, d + 1);
    }
}