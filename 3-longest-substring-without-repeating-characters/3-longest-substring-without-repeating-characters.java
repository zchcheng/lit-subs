class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int n = s.length();
        
        for(int i = 0, l = -1; i < n; i++) {
            char c = s.charAt(i);
            int last = map.getOrDefault(c, -1);
            l = Math.max(l, last);
            res = Math.max(res, i - l);
            map.put(c, i);
        }
        
        return res;
    }
}