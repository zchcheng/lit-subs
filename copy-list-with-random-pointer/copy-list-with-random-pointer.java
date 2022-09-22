/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> newNodeMap = new HashMap<>();
        
        Node result = new Node(-1);
        Node current = result;
        Node old = head;
        
        while(old != null) {
            current.next = new Node(old.val);
            newNodeMap.put(old, current.next);
            current = current.next;
            old = old.next;
        }
        
        old = head;
        current = result.next;
        while(old != null) {
            if (old.random != null) {
                current.random = newNodeMap.get(old.random);
            }
            
            old = old.next;
            current = current.next;
        }
        
        return result.next;
    }
}