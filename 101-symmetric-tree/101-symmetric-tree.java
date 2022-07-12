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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            
            if (l == null && r != null || l != null && r == null) return false;
            if (l == null) continue;
            if (l.val != r.val)  return false;
            
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        
        return true;
    }
}