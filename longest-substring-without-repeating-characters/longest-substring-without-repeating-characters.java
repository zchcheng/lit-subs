class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int res = 0;
        
        for(int i = 0, cur = -1; i < s.length(); i++) {
            char c = s.charAt(i);
            cur = Math.max(m.getOrDefault(c, -1), cur);
            m.put(c, i);
            res = Math.max(res, i - cur);
        }

        return res;
    }
}