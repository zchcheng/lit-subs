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
        switch(op) {
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
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
        Pair<Integer, Node> p = helper(postfix, 0, postfix.length - 1);
        return p.getValue();
    }
    
    Pair<Integer, Node> helper(String[] postfix, int s, int e) {
        if (isOp(postfix[e])) {
            OpNode node = new OpNode(postfix[e].charAt(0));
            
            Pair<Integer, Node> rp = helper(postfix, s, e - 1);
            node.right = rp.getValue();
            
            if (rp.getKey() > s) {
                Pair<Integer, Node> lp = helper(postfix, s, rp.getKey() - 1);
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