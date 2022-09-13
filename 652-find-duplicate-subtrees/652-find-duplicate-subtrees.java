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
    List<TreeNode> res = new ArrayList<>();
    Set<String> seen = new HashSet<>();
    Set<String> added = new HashSet<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializeHelper(root);
        return res;
    }
    
    String serializeHelper(TreeNode root) {
        if (root == null) return "n";
        
        String ls = serializeHelper(root.left);
        String rs = serializeHelper(root.right);
        
        String serialized = ls + "," + rs + "," + root.val;
        
        if (seen.contains(serialized) && !added.contains(serialized)) {
            res.add(root);
            added.add(serialized);
        } else if (!seen.contains(serialized)) {
            seen.add(serialized);
        }
        
        return serialized;
    }
}