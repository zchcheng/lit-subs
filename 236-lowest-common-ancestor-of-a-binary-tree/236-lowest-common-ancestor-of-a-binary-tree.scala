/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

import scala.collection.mutable._

object Solution {
  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {

    val ppath: Stack[TreeNode] = Stack()
    getPath(root, p, ppath)
    val nodes: Set[TreeNode] = Set.from(ppath)

    val qpath: Stack[TreeNode] = Stack()
    getPath(root, q, qpath)
    var res: TreeNode = null
    while (res == null && qpath.nonEmpty) {
      val node = qpath.pop
      if (nodes.contains(node)) {
        res = node
      }
    }

    res
  }

  def getPath(root: TreeNode, p: TreeNode, path: Stack[TreeNode]): Boolean = {
    if (root == null) false
    else if (root == p) {
      path.push(p)
      true
    } else {
      path.push(root)
      if (getPath(root.left, p, path)) {
        true
      } else if (getPath(root.right, p, path)) {
        true
      } else {
        path.pop()
        false
      }
    }
  }
}