class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        
        for(int i = 0; i < tokens.length; i++) {
            String tok = tokens[i];
            
            if (tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/")) {
                int v2 = stack.pop();
                int v1 = stack.pop();
                
                if (tok.equals("+")) stack.push(v1 + v2);
                else if (tok.equals("-")) stack.push(v1 - v2);
                else if (tok.equals("*")) stack.push(v1 * v2);
                else stack.push(v1 / v2);
                
                continue;
            }
            
            stack.push(Integer.valueOf(tok));
        }
        
        return stack.peek();
    }
}