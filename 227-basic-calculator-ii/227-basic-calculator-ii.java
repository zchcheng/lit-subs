class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int cur = 0;
        Character op = '+';
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                cur = cur * 10 + Character.getNumericValue(c);
            }
            
            if ((c != ' ' && !Character.isDigit(c)) || i == s.length() - 1) {
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
        }
        
        int res = 0;
        
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
}