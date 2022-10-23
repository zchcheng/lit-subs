/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node current = root;
        Node leftMost = root;
        
        while(current != null) {
            if (current.left != null) {
                current.left.next = current.right;
            }
            
            if (current.right != null && current.next != null) {
                current.right.next = current.next.left;
            }
            
            if (current.next == null) {
                current = leftMost.left;
                leftMost = current;
            } else {
                current = current.next;
            }
        }
        
        return root;
    }
}