class Solution {
    public int characterReplacement(String s, int k) {
        int[] bucket = new int[26];
        int res = 0;
        
        for(int i = 0, curMax = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curMax = Math.max(curMax, ++bucket[c - 'A']);
            if (res - curMax < k) {
                res++;
            } else {
                bucket[s.charAt(i - res) - 'A']--;
            }
        }
        
        return res;
    }
}