object Solution {
    def kthSmallest(root: TreeNode, k: Int): Int = {
        val (_, _, res) = helper(root, k)
        res
    }

    def helper(root: TreeNode, k: Int): (Boolean, Int, Int) = {
        if (root == null) (false, 0, 0)
        else {
            val (lf, ls, lr) = helper(root.left, k)
            if (lf) (lf, ls, lr) 
            else {
                if (ls == k - 1) (true, k, root.value)
                else {
                    val (rf, rs, rr) = helper(root.right, k - ls - 1)
                    if (rf) (rf, rs, rr)
                    else (false, ls + rs + 1, 0)
                }
            }
        }
    }
}