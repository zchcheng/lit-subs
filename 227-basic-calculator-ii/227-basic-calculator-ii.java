class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char previousOp = '+';
        
        for(int i = 0, current = 0; i <= s.length(); i++) {
            char c = (i == s.length())? '+' : s.charAt(i);
            
            if (c == ' ') continue;
            
            if (Character.isDigit(c)) {
                current = current * 10 + Character.getNumericValue(c);
                continue;
            }
            
            if (previousOp == '*') stack.push(stack.pop() * current);
            if (previousOp == '/') stack.push(stack.pop() / current);
            if (previousOp == '-') stack.push(-current);
            if (previousOp == '+') stack.push(current);
            
            current = 0;
            previousOp = c;
        }
        
        int res = 0;
        
        while(!stack.isEmpty()) res += stack.pop();
        
        return res;
    }
}