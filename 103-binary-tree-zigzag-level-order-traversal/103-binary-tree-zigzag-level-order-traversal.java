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
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(root, 0);
        
        for(int i = 0; map.containsKey(i); i++) {
            List<Integer> list = map.get(i);
            
            if (i % 2 == 1) {
                Collections.reverse(list);
            }
            
            res.add(list);
        }
        
        return res;
    }
    
    void helper(TreeNode root, int d) {
        if (root == null) return;
        
        List<Integer> list = map.computeIfAbsent(d, k -> new ArrayList<>());
        list.add(root.val); 
        
        helper(root.left, d + 1);
        helper(root.right, d + 1);
    }
}