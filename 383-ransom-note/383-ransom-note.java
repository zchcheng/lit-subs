class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> wordCnt = new HashMap<>();
        
        for(char c : magazine.toCharArray()) {
            wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            int cnt = wordCnt.getOrDefault(c, 0);
            if (cnt <= 0) return false;
            wordCnt.put(c, cnt - 1);
        }
        
        return true;
    }
}