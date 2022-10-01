class Solution {
    public int myAtoi(String s) {
        int p = 0;
        
        // remove leading spaces
        while(s.length() > p && s.charAt(p) == ' ') p++;
        
        boolean isNegative = false;
        if (s.length() > p && (s.charAt(p) == '+' || s.charAt(p) == '-')) {
            if (s.charAt(p) == '-') isNegative = true;
            p++;
        }
        
        int result = 0;
        
        while(s.length() > p && Character.isDigit(s.charAt(p))) {
            int v = Character.getNumericValue(s.charAt(p++));
            
            if (result > 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && v >= Integer.MAX_VALUE % 10))) return Integer.MAX_VALUE;
            
            if (result < 0 && (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && v >= Integer.MAX_VALUE % 10 + 1))) return Integer.MIN_VALUE;
            
            if (result < 0) v = -v;
            result = result * 10 + v;
            
            if (isNegative && result != 0) {
                result = -result;
                isNegative = !isNegative;
            }
        }
              
        return result;
    }
}