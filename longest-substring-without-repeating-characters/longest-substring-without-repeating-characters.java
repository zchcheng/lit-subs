class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> prevIndex = new HashMap<>();
        
        int result = 0;
        int lpointer = -1;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lpointer = Math.max(lpointer, prevIndex.getOrDefault(c, -1));
            result = Math.max(i - lpointer, result);
            prevIndex.put(c, i);
        }
        
        return result;
    }
}