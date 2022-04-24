/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<State> stack = new Stack<>();
        
        stack.push(new State(root));
        
        while(!stack.isEmpty()) {
            State state = stack.peek();
            
            if (state.foundAll()) return state.node;
            
            if (state.isDone()) {
                
                stack.pop();
                
                if (!stack.isEmpty()) {
                    stack.peek().fp = state.fp || stack.peek().fp;
                    stack.peek().fq = state.fq || stack.peek().fq;
                }
                
                continue;
            }
            
            if (!state.ld) {
                state.ld = true;
                if (state.node.left != null) stack.push(new State(state.node.left));
            } else {
                state.rd = true;
                if (state.node.right != null) stack.push(new State(state.node.right));
            }
            
            if (state.node == p) state.fp = true;
            if (state.node == q) state.fq = true;
        }
        
        return null;
    }
}

class State {
    public TreeNode node;
    public boolean ld;
    public boolean rd;
    public boolean fp;
    public boolean fq;
    
    public State(TreeNode root) {
        this.node = root;
    }
    
    public boolean isDone() {
        return ld && rd;
    }
    
    public boolean foundAll() {
        return fp && fq;
    }
}
