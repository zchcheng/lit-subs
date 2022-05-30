/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root == p || root == q || (root.value > q.value && root.value < p.value) || (root.value > p.value && root.value < q.value)) root
        else if (root.value < p.value) lowestCommonAncestor(root.right, p, q)
        else lowestCommonAncestor(root.left, p, q)
    }
}