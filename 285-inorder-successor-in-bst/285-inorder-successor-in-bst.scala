/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def inorderSuccessor(root: TreeNode, p: TreeNode): TreeNode = {
        var current = root
        
        while(current != null && current.value != p.value) {
            var next: TreeNode = null
            
            if (current.value < p.value) {
                next = current.right
                
                var prev = next.left
                while(prev != null && prev.right != next) prev = prev.right
                
                if (prev != null) prev.right = null
                
            } else {
                next = current.left
                
                var prev = next
                while(prev != null && prev.right != null) prev = prev.right
                
                if (prev != null) prev.right = current
            }
            
            current = next
        }
        
        if (current == null) null
        else {
            var next = current.right
            var prev = if (next == null) null else next.left
            
            while(prev != null && prev != next) prev = prev.right
            
            if (prev == null) while(next != null && next.left != null) next = next.left
            
            next
        }
    }
}