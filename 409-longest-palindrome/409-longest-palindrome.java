class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> wordCnt = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
        }
        
        int result = 0;
        boolean hasOddCnt = false;
        for(Map.Entry<Character, Integer> kv : wordCnt.entrySet()) {
            result += (kv.getValue() / 2) * 2;
            if (kv.getValue() % 2 != 0) hasOddCnt = true;
        }
        
        return result + ((hasOddCnt)? 1 : 0);
    }
}