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
    def levelOrder(root: TreeNode): List[List[Int]] = {
        var res: List[List[Int]] = List()
        val queue: Queue[TreeNode] = Queue()
        
        if (root != null) { queue.enqueue(root) }
        
        while(queue.nonEmpty) {
            val qs = queue.length
            var list: List[Int] = List()
            
            for(i <- 1 to qs) {
                val n = queue.dequeue
                list = list :+ n.value
                if (n.left != null) { queue.enqueue(n.left) }
                if (n.right != null) { queue.enqueue(n.right) }
            }
            
            res = res :+ list
        }
        
        res
    }
}