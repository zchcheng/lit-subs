/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def diameterOfBinaryTree(root: TreeNode): Int = {
        helper(root)._2
    }
    
    def helper(root: TreeNode): (Int, Int) = {
        if (root == null) (-1, 0)
        else {
            val (ll, ml) = helper(root.left)
            val (lr, mr) = helper(root.right)
            ((ll + 1) max (lr + 1), ml max mr max (2 + ll + lr))
        }
    }
}