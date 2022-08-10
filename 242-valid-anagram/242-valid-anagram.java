class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        
        if (s.length() != t.length()) return false;
        
        for(int i = 0; i < s.length(); i++) {
            cnt[(int)(s.charAt(i) - 'a')] += 1;
            cnt[(int)(t.charAt(i) - 'a')] -= 1;
        }
        
        for(int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) return false;
        }
        
        return true;
    }
}