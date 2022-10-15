class Solution {
    public boolean isAnagram(String s, String t) {
        int[] b1 = getBucket(s);
        int[] b2 = getBucket(t);
        
        for(int i = 0; i < 26; i++) if (b1[i] != b2[i]) return false;
        
        return true;
    }
    
    int[] getBucket(String s) {
        int[] result = new int[26];
        for(char c : s.toCharArray()) result[c - 'a']++; 
        return result;
    }
}