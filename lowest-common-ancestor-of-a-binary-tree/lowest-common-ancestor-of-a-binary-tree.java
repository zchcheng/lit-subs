/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }
        
        
        Set<TreeNode> path = new HashSet<>();
        
        while(p != null) {
            path.add(p);
            p = parent.get(p);
        }
        
        while(!path.contains(q)) q = parent.get(q);
        
        return q;
    }
}