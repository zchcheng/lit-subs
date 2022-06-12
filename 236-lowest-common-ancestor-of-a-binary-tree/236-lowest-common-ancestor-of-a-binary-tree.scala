import scala.collection.mutable._

object Solution {
  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {
    recursionHelper(root, p, q)._1
  }

  def recursionHelper(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): (TreeNode, Boolean) = {
    if (root == null) (null, false)
    else {
      var found: Int = 0

      if (root == p || root == q) found += 1

      val (lres, lf) = recursionHelper(root.left, p, q)
      val (rres, rf) = recursionHelper(root.right, p, q)

      if (lres != null) (lres, true)
      else if (rres != null) (rres, true)
      else {
        if (lf) found += 1
        if (rf) found += 1
        if (found >= 2) (root, true)
        else (null, found > 0)
      }
    }
  }
}