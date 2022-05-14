/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class ValNode extends Node {
    public int val;
    
    public ValNode(int val) {
        this.val = val;
    }
    
    @Override
    public int evaluate() {
        return val;
    }
}

class OpNode extends Node {
    public Node left;
    public Node right;
    public char op;
    
    public OpNode(char c) {
        op = c;
    }
        
    @Override
    public int evaluate() {
        int lv = (left == null)? 0 : left.evaluate();
        int rv = (right == null)? 0 : right.evaluate();
        switch(op) {
            case '+':
                return lv + rv;
            case '-':
                return lv - rv;
            case '*':
                return lv * rv;
            case '/':
                return lv / rv;
        }
        return 0;
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        /**
         * DFS approach
         * Pair<Integer, Node> p = dfs(postfix, 0, postfix.length - 1);
         * return p.getValue();
         */
        
        Stack<OpNode> stack = new Stack<>();
        
        for(int i = postfix.length - 1; i >= 0; i--) {
            String s = postfix[i];
            if (isOp(s)) {
                OpNode node = new OpNode(s.charAt(0));
                stack.push(node);
            } else {
                ValNode node = new ValNode(Integer.valueOf(s));
                OpNode parent = stack.peek();
                
                if (parent.right == null) {  parent.right = node; } 
                else { parent.left = node; }
                
                while(stack.peek().left != null && stack.peek().right != null) {
                    OpNode n = stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(n);
                        break;
                    }
                    if (stack.peek().right == null) { stack.peek().right = n; }
                    else { stack.peek().left = n; }
                }
            }
        }
        
        return stack.peek();
    }
    
    Pair<Integer, Node> dfs(String[] postfix, int s, int e) {
        if (isOp(postfix[e])) {
            OpNode node = new OpNode(postfix[e].charAt(0));
            
            Pair<Integer, Node> rp = dfs(postfix, s, e - 1);
            node.right = rp.getValue();
            
            if (rp.getKey() > s) {
                Pair<Integer, Node> lp = dfs(postfix, s, rp.getKey() - 1);
                node.left = lp.getValue();
                return new Pair(lp.getKey(), node);
            }
            
            return new Pair(s, node);
        } 
        
        return new Pair(e, new ValNode(Integer.valueOf(postfix[e])));
    }
    
    boolean isOp (String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
};

/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */