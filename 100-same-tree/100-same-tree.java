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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        
        queue.offer(new Pair(p, q));
        
        while(!queue.isEmpty()) {
            Pair<TreeNode, TreeNode> pair = queue.poll();
            int v1 = (pair.getKey() == null)? Integer.MIN_VALUE : pair.getKey().val;
            int v2 = (pair.getValue() == null)? Integer.MIN_VALUE : pair.getValue().val;
            if (v1 != v2) return false;
            
            if (v1 != Integer.MIN_VALUE && v2 != Integer.MIN_VALUE) {
                queue.offer(new Pair(pair.getKey().left, pair.getValue().left));
                queue.offer(new Pair(pair.getKey().right, pair.getValue().right));
            }
        }
        
        return true;
    }
}