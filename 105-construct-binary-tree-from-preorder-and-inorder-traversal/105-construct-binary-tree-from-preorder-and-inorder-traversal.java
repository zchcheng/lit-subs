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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> idx = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            idx.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, idx);
    }
    
    TreeNode helper(int[] preorder, int sp, int ep, int[] inorder, int si, int ei, Map<Integer, Integer> idx) {
        if (sp > ep) {
            return null;
        }
        
        TreeNode res = new TreeNode(preorder[sp]);
        
        int i = idx.get(preorder[sp]);
        int lsz = i - si;
        int rsz = ei - i;
        
        res.left = helper(preorder, sp + 1, sp + lsz, inorder, si, i - 1, idx);
        res.right = helper(preorder, sp + lsz + 1, ep, inorder, i + 1, ei, idx);
        
        return res;
    }
}