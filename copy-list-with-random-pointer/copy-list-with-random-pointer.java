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
        Map<Node, Node> copyOfNode = new HashMap<>();
        
        Node result = new Node(-1);
        Node current = result;
        Node ch = head;
        
        while(ch != null) {
            Node node = new Node(ch.val);
            current.next = node;
            copyOfNode.put(ch, node);
            
            ch = ch.next;
            current = current.next;
        }
        
        ch = head;
        current = result.next;
        
        while(ch != null) {
            if (ch.random != null) current.random = copyOfNode.get(ch.random);
            ch = ch.next;
            current = current.next;
        }
        
        return result.next;
    }
}