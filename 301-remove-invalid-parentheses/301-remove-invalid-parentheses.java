class Solution {
    Set<String> res = new HashSet<>();
    
    public List<String> removeInvalidParentheses(String s) {
        int[] canBeRemoved = getNumOfParenthesesCanBeRemoved(s);
        
        helper(s, 0, 0, canBeRemoved[0], canBeRemoved[1], "");
        
        return new ArrayList<>(res);
    }
    
    int[] getNumOfParenthesesCanBeRemoved(String s) {
        int stack = 0;
        
        int rtr = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ')' && stack == 0) rtr++;
            else stack += (c == ')')? -1 : (c == '(')? 1 : 0;
        }
        
        return new int[] { stack, rtr };
    }
    
    void helper(String s, int idx, int stack, int ltr, int rtr, String current) {
        if (stack < 0) return;
        
        if (idx == s.length()) {
            if (stack == 0) res.add(current);
            return;
        }
        
        char c = s.charAt(idx);
        
        if (c == '(') {
            
            if (ltr > 0) helper(s, idx + 1, stack, ltr - 1, rtr, current);
            helper(s, idx + 1, stack + 1, ltr, rtr, current + "(");
            
        } else if (c == ')') {
            
            if (rtr > 0) helper(s, idx + 1, stack, ltr, rtr - 1, current);
            if (stack > 0) helper(s, idx + 1, stack - 1, ltr, rtr, current + ")");
            
        } else {
            helper(s, idx + 1, stack, ltr, rtr, current + c);
        }
    }
}