/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isValidBST(root: TreeNode): Boolean = {
        validate(root)._3
    }
    
    def validate(root: TreeNode): (Long, Long, Boolean) = {
        if (root == null) {
            (Long.MaxValue, Long.MinValue, true)
        } else {
            val (lmin, lmax, lvld) = validate(root.left)
            val (rmin, rmax, rvld) = validate(root.right)
            (lmin min root.value, rmax max root.value,  root.value > lmax && root.value < rmin && lvld && rvld)
        }
    }
}