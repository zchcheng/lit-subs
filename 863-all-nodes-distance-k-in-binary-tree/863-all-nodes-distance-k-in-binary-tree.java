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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        helper(root, null, map);
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(target.val);
        
        for(int i = 0; i < k; i++) {
            for(int j = q.size(); j > 0; j--) {
                int n = q.poll();
                visited.add(n);
                
                Set<Integer> conn = map.get(n);
                
                if (conn == null) continue;
                
                for(int c : conn) {
                    if (visited.contains(c)) continue;
                    q.offer(c);
                }
            }
        }
        
        return (List<Integer>)q;
    }
    
    void helper(TreeNode root, TreeNode parent, Map<Integer, Set<Integer>> map) {
        if (root == null) return;
        
        Set<Integer> conn = map.computeIfAbsent(root.val, v -> new HashSet<>());
        
        if (parent != null) {
            conn.add(parent.val);
        }
        
        if (root.left != null) {
            conn.add(root.left.val);
            helper(root.left, root, map);
        }
        
        if (root.right != null) {
            conn.add(root.right.val);
            helper(root.right, root, map);
        }
    }
}