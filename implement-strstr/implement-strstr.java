class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = buildLPS(needle);
        
        for(int i = 0, j = -1; i < haystack.length(); i++) {
            j = findPattern(lps, haystack.charAt(i), j, needle);
            if (j == needle.length() - 1) return i - needle.length() + 1;
        }
        
        return -1;
    }
    
    int findPattern(int[] lps, char c, int idx, String str) {
        idx++;
        
        while(idx >= 0 && str.charAt(idx) != c) {
            if (idx <= 0) {
                idx = -1;
                break;
            }
            idx = lps[idx - 1] + 1;
        }
        
        return idx;
    }
    
    int[] buildLPS(String str) {
        int[] lps = new int[str.length()];
        
        Arrays.fill(lps, -1);
        
        for(int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            
            int j = lps[i - 1] + 1;
            
            while(j >= 0 && str.charAt(j) != c) {
                if (j == 0) {
                    j = -1;
                    break;
                }
                j = lps[j - 1] + 1;
            }
            
            lps[i] = j;
        }
        
        return lps;
    }
}