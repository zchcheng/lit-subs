class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = buildLPS(needle);
        
        for(int i = 0, j = 0; i < haystack.length(); i++) {
            j = findPattern(lps, needle, haystack.charAt(i), j);
            if (j == needle.length()) return i - needle.length() + 1;
        }
        
        return -1;
    }
    
    int findPattern(int[] lps, String str, char c, int idx) {
        while(idx >= 0) {
            char cc = str.charAt(idx);
            if (cc == c) return idx + 1;
            if (idx == 0) return 0;
            else idx = lps[idx - 1] + 1;
        }
        
        return 0;
    }
    
    int[] buildLPS(String str) {
        int[] result = new int[str.length()];
        
        Arrays.fill(result, -1);
        
        for(int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            
            int idx = result[i - 1] + 1;
            
            while(idx >= 0) {
                if (str.charAt(idx) == c) break;
                if (idx == 0) idx = -1;
                else idx = result[idx - 1] + 1;
            }
            
            result[i] = idx;
        }
        
        return result;
    }
}