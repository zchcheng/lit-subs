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
        Node current = head;
        
        while(current != null) {
            Node next = current.next;
            current.next = new Node(current.val);
            current.next.next = next;
            current = next;
        }
        
        current = head;
        
        while(current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        current = head;
        Node result = new Node(-1);
        Node tail = result;
        
        while(current != null) {
            Node next = current.next.next;
            
            tail.next = current.next;
            tail = tail.next;
            
            current.next = next;
            current = next;
        }
        
        return result.next;
    }
}