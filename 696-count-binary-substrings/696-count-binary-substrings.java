class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        
        for(int i = 1, cons = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char oc = (c == '1')? '0' : '1';
            
            if (s.charAt(i - 1) != c) cons = 0;
            int pi = i - 2 * cons - 1;
            
            if (pi >= 0 && s.charAt(pi) == oc) {
                cons++;
                res++;
            } else cons = 0;
        }
        
        return res;
    }
}