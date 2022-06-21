/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable._

object Solution {
  def rightSideView(root: TreeNode): List[Int] = {
    val res: ListBuffer[Int] = new ListBuffer()
    helper(root, 0, res)
    res.toList
  }

  def helper(root: TreeNode, d: Int, res: ListBuffer[Int]): Unit = {
    if (root != null) {
      if (d >= res.length) res += root.value
      helper(root.right, d + 1, res)
      helper(root.left, d + 1, res)
    }
  }
}