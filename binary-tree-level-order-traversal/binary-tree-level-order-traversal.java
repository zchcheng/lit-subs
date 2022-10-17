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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root != null) queue.offer(root);
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < sz; i++) {
                TreeNode n = queue.poll();
                list.add(n.val);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            
            result.add(list);
        }
        
        return result;
    }
}