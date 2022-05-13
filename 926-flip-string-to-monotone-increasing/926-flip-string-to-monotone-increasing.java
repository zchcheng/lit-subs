class Solution {
    public int minFlipsMonoIncr(String s) {
        int n1 = 0;
        int res = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                res = Math.min(res + 1, n1);
            } else {
                n1++;
            }
        }
        
        return res;
    }
}