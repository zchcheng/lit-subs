/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

import scala.collection.mutable._

class Codec {
    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
        val res = serializer(root)
        res
    }
    
    private def serializer(root: TreeNode): String = {
        if (root == null) { "" } 
        else { root.value + "," + serializer(root.left) + "," + serializer(root.right) }
    }
    
    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
        deserializer(data.split(","), 0)._1
    }

    private def deserializer(data: Array[String], s: Int): (TreeNode, Int) = {
        if (s >= data.length || data(s).isEmpty()) {
            (null, s)
        } else {
            val value = Integer.parseInt(data(s))
            val node = TreeNode(value)
            val (lc, ls) = deserializer(data, s + 1)
            val (rc, rs) = deserializer(data, ls + 1)
            node.left = lc
            node.right = rc
            
            (node, rs)
        }
    }
}


/**
 * Your Codec object will be instantiated and called as such:
 * var ser = new Codec()
 * var deser = new Codec()
 * val s = ser.serialize(root)
 * val ans = deser.deserialize(s)
 */