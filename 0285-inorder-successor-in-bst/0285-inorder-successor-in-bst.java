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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (true) {
            if (root.val == p.val) {
                TreeNode res = root.right;
                while(res != null && res.left != null) res = res.left;
                return res;
            }
                
            if (root.val < p.val)
                root = root.right;
            else {
                TreeNode next = root.left;
                TreeNode prev = getPrev(root);
                root.left = null;
                prev.right = root;
                root = next;
            }
        }
    }

    TreeNode getPrev(TreeNode n) {
        if (n == null)
            return null;
        n = n.left;
        while (n != null && n.right != null) {
            n = n.right;
        }
        return n;
    }
}