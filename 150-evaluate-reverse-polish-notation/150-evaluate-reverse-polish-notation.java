class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String tok : tokens) {
            if (tok.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tok.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (tok.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tok.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tok));
            }
        }
        
        return stack.pop();
    }
}