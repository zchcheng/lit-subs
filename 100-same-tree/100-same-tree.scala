/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        if (p == null || q == null) p == null && q == null
        else if (p.value == q.value) isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        else false
    }
}