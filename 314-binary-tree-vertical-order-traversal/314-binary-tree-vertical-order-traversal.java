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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int min = 0;
        int max = 0;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        
        if (root == null) return res;
        
        queue.offer(new Pair(root, 0));
        
        // BFS traverse
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            
            List<Integer> list = map.getOrDefault(pair.offset, new ArrayList<>());
            list.add(pair.root.val);
            map.put(pair.offset, list);
            min = Math.min(min, pair.offset);
            max = Math.max(max, pair.offset);
            
            if (pair.root.left != null) queue.offer(new Pair(pair.root.left, pair.offset - 1));
            if (pair.root.right != null) queue.offer(new Pair(pair.root.right, pair.offset + 1));
        }
        
        // Collect the result
        for(int i = min; i <= max; i++) {
            List<Integer> list = map.get(i);
            if (list != null) res.add(list);
        }
        
        return res;
    }
    
    class Pair {
        public TreeNode root;
        public int offset;
        
        public Pair(TreeNode root, int offset) {
            this.root = root;
            this.offset = offset;
        }
    }
}