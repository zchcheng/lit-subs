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

/*
     1
   2   3
  4 5 6 7
  
  1
  3

  2 3
  
  76
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean f = true;
        
        if (root != null) stack.push(root);
        
        while(!stack.isEmpty()) {
            Stack<TreeNode> next = new Stack<>();
            List<Integer> list = new ArrayList<>();
            
            while(!stack.isEmpty()) {
                TreeNode n = stack.pop();
                list.add(n.val);
                if (f) {
                    if (n.left != null) next.push(n.left);
                    if (n.right != null) next.push(n.right);
                } else {
                    if (n.right != null) next.push(n.right);
                    if (n.left != null) next.push(n.left);
                }
            }
            
            res.add(list);
            stack = next;
            f = !f;
        }

        return res;
    }
}