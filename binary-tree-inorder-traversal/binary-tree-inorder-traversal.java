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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            
            res.add(n.val);
            
            TreeNode tmp = n.right;
            while(tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        
        return res;
    }
}