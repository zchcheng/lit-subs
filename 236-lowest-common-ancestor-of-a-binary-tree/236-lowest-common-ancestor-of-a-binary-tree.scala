import scala.collection.mutable._

case class CustomNode(node: TreeNode, var visit: Int, var found: Int)

object Solution {
  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {
    val stack: Stack[CustomNode] = Stack()
    var res: TreeNode = null

    stack.push(CustomNode(root, 0, 0))

    while (res == null && stack.nonEmpty) {
      val node = stack.top.node
      val visit = stack.top.visit
      val found = stack.top.found

      if (node == null) {
        stack.pop
        stack.top.visit += 1
      } else {
        if (visit == 0) {
          if (node == p || node == q) {
            stack.top.found += 1
          }
          stack.push(CustomNode(node.left, 0, 0))
        } else {
          if (found >= 2) {
            res = node
          } else {
            if (visit == 1) {
              stack.push(CustomNode(node.right, 0, 0))
            } else {
              stack.pop
              stack.top.visit += 1
              stack.top.found += found
            }
          }
        }
      }
    }

    res
  }
}