/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Stack<Node> numStack = new Stack<Node>();
    Stack<Node> opStack = new Stack<Node>();
        
    public Node expTree(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                numStack.push(new Node(c));
                continue;
            }
            
            if (c == '+' || c == '-') {
                while(!opStack.isEmpty() && numStack.size() >= 2 && opStack.peek().val != '(') popOpNode();
            }
            
            if (c == '*' || c == '/') {
                while(!opStack.isEmpty() && (opStack.peek().val == '*' || opStack.peek().val == '/') && numStack.size() >= 2) popOpNode();
            }
            
            if (c == ')') {
                while(!opStack.isEmpty() && opStack.peek().val != '(') popOpNode();
                if (!opStack.isEmpty()) opStack.pop();
            }
            
            if (c != ')') opStack.push(new Node(c));
        }
        
        while(!opStack.isEmpty()) popOpNode();
        
        return numStack.peek();
    }
    
    void popOpNode() {
        Node op = opStack.pop();
        op.right = numStack.pop();
        op.left = numStack.pop();
        numStack.push(op);
    }
}