object Solution {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    var map: Map[Int, Int] = Map()

    inorder.zipWithIndex.foreach { case (v, i) => map += (v -> i) }

    helper(0, preorder.length - 1, 0, inorder.length - 1)(
      preorder,
      inorder,
      map
    )
  }

  def helper(ps: Int, pe: Int, is: Int, ie: Int)(
      preorder: Array[Int],
      inorder: Array[Int],
      map: Map[Int, Int]
  ): TreeNode = {
    if (ps <= pe) {
      val v = preorder(ps)
      val res = new TreeNode(v)
      val index = map.get(v).get
      val lsize = index - 1 - is + 1
      val rsize = ie - index

      res.left =
        helper(ps + 1, ps + lsize, is, index - 1)(preorder, inorder, map)
      res.right =
        helper(ps + lsize + 1, pe, index + 1, ie)(preorder, inorder, map)

      res
    } else null
  }
}