/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    
    public Node lowestCommonAncestor(Node p, Node q) {
        
        while(p != null) {
            map.put(p.val, p);
            p = p.parent;
        }
        
        while(q != null) {
            Node n = map.get(q.val);
            
            if (n != null) return n;
            
            q = q.parent;
        }
        
        return null;
    }
}