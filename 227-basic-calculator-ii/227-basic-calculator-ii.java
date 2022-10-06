class Solution {
    public int calculate(String s) {
        // A op1 B op2 C
        // if (op2 == '+' || op2 == '-') => result += A op1 B
        // else B = B op2 C
        
        int result = 0;
        int val = 0;
        
        char op1 = '+';
        char op2 = '+';
        
        for(int i = 0, currentVal = 0; i <= s.length(); i++) {
            char c = (i == s.length())? '+' : s.charAt(i);
            
            if (c == ' ') continue;
            
            if (Character.isDigit(c)) {
                currentVal = currentVal * 10 + Character.getNumericValue(c);
                continue;
            }
            
            if (op2 == '+' || op2 == '-') {
                result = cal(result, val, op1);
                op1 = op2;
                op2 = c;
                val = currentVal;
            } else {
                val = cal(val, currentVal, op2);
                op2 = c;
            }
            
            currentVal = 0;
        }
        
        return cal(result, val, op1);
    }
    
    int cal(int val1, int val2, char op) {
        if (op == '+') return val1 + val2;
        if (op == '-') return val1 - val2;
        if (op == '*') return val1 * val2;
        return val1 / val2;
    }
}