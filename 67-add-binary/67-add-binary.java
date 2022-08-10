class Solution {
    public String addBinary(String a, String b) {
        int i1 = a.length() - 1;
        int i2 = b.length() - 1;
        int c = 0;
        
        StringBuilder result = new StringBuilder();
        
        while(i1 >= 0 || i2 >= 0) {
            int v1 = (i1 >= 0)? Character.getNumericValue(a.charAt(i1--)) : 0;
            int v2 = (i2 >= 0)? Character.getNumericValue(b.charAt(i2--)) : 0;
            
            int s = v1 + v2 + c;
            result.append((s % 2));
            c = s / 2;
        }
        
        if (c != 0) result.append(1);
        
        result = result.reverse();
        
        return result.toString();
    }
}