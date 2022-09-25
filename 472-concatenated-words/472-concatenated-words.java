class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        
        for(String w : words) {
            if (canFormWord(w, preWords)) result.add(w);
            preWords.add(w);
        }
        
        return result;
    }
    
    boolean canFormWord(String word, Set<String> words) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                dp[i] = words.contains(word.substring(j, i));
                if (dp[i]) break;
            }
        }
        
        return dp[word.length()];
    }
}