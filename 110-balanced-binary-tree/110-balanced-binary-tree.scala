/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isBalanced(root: TreeNode): Boolean = {
        val (h, d) = helper(root)
        d <= 1
    }
    
    def helper(root: TreeNode): (Int, Int) = {
        if (root == null) (0, 0)
        else {
            val (hl, dl) = helper(root.left) 
            val (hr, dr) = helper(root.right)
            ((hl max hr) + 1, ((dl max dr) max (hl - hr).abs))
        }
    }
}