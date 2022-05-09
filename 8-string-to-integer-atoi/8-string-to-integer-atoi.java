class Solution {
    public int myAtoi(String s) {
        Integer res = null;
        Boolean isNeg = null;
        
        int idx = 0;
        for(; idx < s.length() && s.charAt(idx) == ' '; idx++);
        
        for(; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            
            if (isNeg == null && res == null && c == '-') {
                isNeg = true;
                continue;
            }
            
            if (isNeg == null && res == null && c == '+') {
                isNeg = false;
                continue;
            }
            
            if (!Character.isDigit(c)) {
                break;
            }
            
            if (res == null) {
                res = 0;
            }
            
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && c >= '7') {
                return Integer.MAX_VALUE;
            }
            
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && c >= '8') {
                return Integer.MIN_VALUE;
            }
            
            res = res * 10 + ((res >= 0)? Character.getNumericValue(c) : -Character.getNumericValue(c));
            
            if (res != 0 && isNeg != null && isNeg == true) {
                res = -res;
                isNeg = false;
            }
        }
        
        return (res == null)? 0 : res;
    }
}