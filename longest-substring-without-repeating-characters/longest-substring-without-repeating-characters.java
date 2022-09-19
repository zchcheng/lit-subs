class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> previousIndex = new HashMap<>();
        
        int left = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (previousIndex.containsKey(c)) {
                left = Math.max(left, previousIndex.get(c));
            }
            
            previousIndex.put(c, i);
            
            result = Math.max(result, i - left);
        }
        
        return result;
    }
}