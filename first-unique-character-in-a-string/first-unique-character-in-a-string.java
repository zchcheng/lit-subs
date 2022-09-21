class Solution {
    public int firstUniqChar(String s) {
        int[] seen = new int[26];
        
        for(char c : s.toCharArray()) {
            seen[(int)(c - 'a')]++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if (seen[(int)(s.charAt(i) - 'a')] < 2) return i;
        }
        
        return -1;
    }
}