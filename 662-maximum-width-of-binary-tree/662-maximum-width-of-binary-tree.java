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
    public int widthOfBinaryTree(TreeNode root) {
        long res = 0;
        
        Queue<Node> queue = new LinkedList<>();
        
        if (root != null) queue.offer(new Node(root, 0));
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            
            for(int i = 0; i < sz; i++) {
                Node p = queue.poll();
                
                min = Math.min(p.offset, min);
                max = Math.max(p.offset, max);
                
                if (p.node.left != null) queue.offer(new Node(p.node.left, p.offset * 2));
                if (p.node.right != null) queue.offer(new Node(p.node.right, p.offset * 2 + 1));
            }
            
            res = Math.max(res, max - min + 1);
        }
        
        return (int)res;
    }
    
    class Node {
        public TreeNode node;
        public long offset;
        
        public Node(TreeNode node, long offset) {
            this.node = node;
            this.offset = offset;
        }
    }
}