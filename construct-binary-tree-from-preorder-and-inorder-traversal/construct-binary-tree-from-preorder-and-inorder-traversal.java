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
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        return helper(0, 0, inorder.length - 1, preorder, inorder, indexMap).getValue();
    }
    
    Pair<Integer, TreeNode> helper(int p, int il, int ir, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (p >= preorder.length || il > ir) return new Pair<>(p, null);
        
        int k = preorder[p];
        int idx = map.get(k);
        
        Pair<Integer, TreeNode> pl = helper(p + 1, il, idx - 1, preorder, inorder, map);
        Pair<Integer, TreeNode> pr = helper(pl.getKey(), idx + 1, ir, preorder, inorder, map);
        
        TreeNode n = new TreeNode(k, pl.getValue(), pr.getValue());
        
        return new Pair<>(pr.getKey(), n);
    }
}