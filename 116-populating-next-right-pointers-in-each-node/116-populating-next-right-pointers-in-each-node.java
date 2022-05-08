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
        Queue<Node> q = new LinkedList<>();
        
        if (root != null) q.offer(root);
        
        while(!q.isEmpty()) {
            Queue<Node> nq = new LinkedList<>();
            Node cur = null;
            
            while(!q.isEmpty()) {
                Node node = q.poll();
                
                if (node.left != null) nq.offer(node.left);
                if (node.right != null) nq.offer(node.right);
                
                if (cur != null) {
                    cur.next = node;
                }
                
                cur = node;
                cur.next = null;
            }
            
            q = nq;
        }
        
        return root;
    }
}