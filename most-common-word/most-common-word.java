class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        for(char c : new char[] { '!', '?', '\'', ',', ';', '.'}) paragraph = paragraph.replace(c + "", " ");
        
        System.out.println(paragraph);
        
        String[] words = paragraph.split(" ");
        
        Set<String> bannedWords = new HashSet<>();
        for(String b : banned) bannedWords.add(b);
        
        Map<String, Integer> freq = new HashMap<>();
        String result = "";
        
        for(String w : words) {
            if (w.isEmpty()) continue;
            
            w = w.toLowerCase();
            
            if (bannedWords.contains(w)) continue;
            
            freq.put(w, freq.getOrDefault(w, 0) + 1);
            if (result.isEmpty() || freq.get(result) < freq.get(w)) result = w;
        }
        
        return result;
    }
}