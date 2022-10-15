class Solution {
    final int PK = Integer.MAX_VALUE / 10;
    final int NK = Integer.MIN_VALUE / 10;
    final int PD = Integer.MAX_VALUE % 10;
    final int ND = PD + 1;
    
    public int myAtoi(String s) {
        int result = 0;
        int ptr = 0;
        boolean isNeg = false;
        
        // remove leading spaces
        while(ptr < s.length() && s.charAt(ptr) == ' ') ptr++;
        
        if (ptr < s.length() && (s.charAt(ptr) == '-' || s.charAt(ptr) == '+')) {
            isNeg = s.charAt(ptr) == '-';
            ptr++;
        }
        
        while(ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            int d = Character.getNumericValue(s.charAt(ptr++));
            
            if (result > 0 && (result > PK || (result == PK && d >= PD))) return Integer.MAX_VALUE;
            if (result < 0 && (result < NK || (result == NK && d >= ND))) return Integer.MIN_VALUE;
            
            if (result >= 0) result = result * 10 + d;
            else result = result * 10 - d;
            
            if (isNeg && result > 0) {
                result = -result;
                isNeg = false;
            }
        }
        
        return result;
    }
}