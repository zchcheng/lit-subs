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
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> ll = new ArrayList<>();
    List<Integer> rl = new ArrayList<>();
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) return res;
        
        res.add(root.val);
            
        lhelper(root.left, true);
        rhelper(root.right, true);
        
        Collections.reverse(right);
        Collections.reverse(rl);
        
        res.addAll(left);
        res.addAll(ll);
        res.addAll(rl);
        res.addAll(right);
        
        return res;
    }
    
    void lhelper(TreeNode root, boolean pb) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            ll.add(root.val);
        } else if (pb) {
            left.add(root.val);
        }
        
        lhelper(root.left, pb);
        lhelper(root.right, pb && root.left == null);
    }
    
    void rhelper(TreeNode root, boolean pb) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            rl.add(root.val);
        } else if (pb) {
            right.add(root.val);
        }
        
        rhelper(root.right, pb);
        rhelper(root.left, pb && root.right == null);
    }
}