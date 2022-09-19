class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int result = 0;
        
        while(index < s.length() && s.charAt(index) == ' ') index++;
        
        boolean isNegative = false;
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            if (s.charAt(index) == '-') isNegative = true;
            index++;
        }
        
        while(index < s.length() && Character.isDigit(s.charAt(index))) {
            int dv = Character.getNumericValue(s.charAt(index++));
            
            if (result == 0 && dv != 0 && isNegative) {
                result = -dv;
                continue;
            }
            
            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            if (!isNegative && result == Integer.MAX_VALUE / 10 && dv >= Integer.MAX_VALUE % 10) return Integer.MAX_VALUE;
            
            if (isNegative && result == Integer.MIN_VALUE / 10 && dv >= (Integer.MAX_VALUE % 10) + 1) return Integer.MIN_VALUE;
            
            result = result * 10 + ((isNegative)? -dv : dv);
        }
        
        return result;
    }
}