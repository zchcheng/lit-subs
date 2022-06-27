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
    def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
        val res: ListBuffer[List[Int]] = ListBuffer()

        helper(root, targetSum, Stack(), res)

        res.toList
    }

    private def helper(root: TreeNode, targetSum: Int, current: Stack[Int], list: ListBuffer[List[Int]]): Unit = {
        if (root != null) {
            if (root.value == targetSum && root.left == null && root.right == null) {
                current.push(root.value)
                list += current.toList.reverse
                current.pop
            } else {
                val sum = targetSum - root.value

                current.push(root.value)

                helper(root.left, sum, current, list)
                helper(root.right, sum, current, list)

                current.pop
            }
        }
    }
}