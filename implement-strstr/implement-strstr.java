class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = buildLps(needle);
        
        for(int i = 0, j = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            
            j = findPattern(lps, c, needle, j);
            
            if (j == needle.length()) return i - needle.length() + 1;
        }
        
        return -1;
    }
    
    int findPattern(int[] lps, char c, String needle, int idx) {
        while(idx >= 0) {
            if (c == needle.charAt(idx)) return idx + 1;
            if (idx == 0) break;
            idx = lps[idx - 1];
        }
        
        return 0;
    }
    
    int[] buildLps(String needle) {
        int[] lps = new int[needle.length()];
        
        for(int i = 1; i < needle.length(); i++) {
            char c = needle.charAt(i);
            
            int idx = i - 1;
            
            while(idx >= 0) {
                if (needle.charAt(lps[idx]) == c) {
                    lps[i] = lps[idx] + 1;
                    break;
                } else {
                    idx = lps[idx] - 1;
                }
            }
        }
        
        return lps;
    }
}