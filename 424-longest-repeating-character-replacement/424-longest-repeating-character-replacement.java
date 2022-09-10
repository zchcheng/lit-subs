class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = -1;
        
        int[] bucket = new int[26];
        
        for(int i = 0, con = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            con = Math.max(con, ++bucket[c - 'A']);
            
            if (i - l - con > k) {
                bucket[s.charAt(++l) - 'A']--;
            }
            
            res = Math.max(res, i - l);
        }
        
        return res;
    }
}