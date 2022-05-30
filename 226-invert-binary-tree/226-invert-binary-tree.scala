/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def invertTree(root: TreeNode): TreeNode = {
        helper(root)
        root
    }
    
    def helper(root: TreeNode): Unit = {
        if (root != null) {
            helper(root.left)
            helper(root.right)
            val left = root.left
            root.left = root.right
            root.right = left
        }
    }
}