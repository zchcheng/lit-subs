class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        char[] carr1 = num1.toCharArray();
        char[] carr2 = num2.toCharArray();
        int i1 = carr1.length - 1;
        int i2 = carr2.length - 1;
        
        StringBuilder res = new StringBuilder();
        while(i1 >= 0 || i2 >= 0) {
            int d1 = (i1 >= 0)? Character.getNumericValue(carr1[i1--]) : 0;
            int d2 = (i2 >= 0)? Character.getNumericValue(carr2[i2--]) : 0;
            int v = d1 + d2 + carry;
            
            carry = v / 10;
            res.append(v % 10);
        }
        
        if (carry > 0) { res.append(carry); }
        res = res.reverse();
        
        return res.toString();
    }
}