class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        
        int cur = 0;
        Character op = '+';
        for(char c : s.toCharArray()) {
            if (c == ' ') continue;
            
            if (Character.isDigit(c)) {
                cur = cur * 10 + Character.getNumericValue(c);
                continue;
            }
            
            if (op == '*') {
                stack.push(stack.pop() * cur);
            } else if (op == '/') {
                stack.push(stack.pop() / cur);
            } else if (op == '-') {
                stack.push(-cur);
            } else {
                stack.push(cur);
            }
            
            op = c;
            cur = 0;
        }
        
        if (op == '*') {
            stack.push(stack.pop() * cur);
        } else if (op == '/') {
            stack.push(stack.pop() / cur);
        } else if (op == '-') {
            stack.push(-cur);
        } else {
            stack.push(cur);
        }
        
        int res = 0;
        
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
}