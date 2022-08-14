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
        Map<Integer, Integer> index = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        
        TreeNode result = helper(new int[] {
            0, preorder.length, 0, inorder.length - 1
        }, preorder, inorder, index);
        return result;
    }
    
    TreeNode helper(int[] n, int[] preorder, int[] inorder, Map<Integer, Integer> index) {
        if (n[1] <= 0) return null;
        
        int v = preorder[n[0]];
        TreeNode node = new TreeNode(v);
        
        int idx = index.get(v);
        int ln = idx - n[2];
        int rn = n[3] - idx;
        
        node.left = helper(new int[] {
            n[0] + 1, ln, n[2], idx - 1
        }, preorder, inorder, index);
        
        node.right = helper(new int[] {
            n[0] + ln + 1, rn, idx + 1, n[3]
        }, preorder, inorder, index);
        
        return node;
    }
}