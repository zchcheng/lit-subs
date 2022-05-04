/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node nn = new Node(insertVal);
        nn.next = nn;
        Node n = head;
        
        if (head == null) return nn;
        
        while(true) {
            if (n.val <= insertVal && n.next.val >= insertVal) {
                insert(n, nn, n.next);
                break;
            }
            
            if (n.val > n.next.val && (insertVal <= n.next.val || insertVal >= n.val)) {
                insert(n, nn, n.next);
                break;
            }
            
            if (n.next == head) {
                insert(n, nn, n.next);
                break;
            }
            
            n = n.next;
        }
            
        return head;
    }
    
    void insert(Node a, Node b, Node c) {
        a.next = b;
        b.next = c;
    }
}