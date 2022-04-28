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
        Map<Node, Node> map = new HashMap<>();
        
        Node dummy = new Node(-1);
        Node copyHead = dummy;
        Node current = head;
        
        while(current != null) {
            Node node = new Node(current.val);
            copyHead.next = node;
            copyHead = node;
            
            map.put(current, node);
            
            current = current.next;
        }
        
        copyHead = dummy.next;
        current = head;
        
        while(current != null) {
            Node r = map.get(current.random);
            if (r != null) {
                copyHead.random = r;
            }
            
            current = current.next;
            copyHead = copyHead.next;
        }
        
        return dummy.next;
    }
}