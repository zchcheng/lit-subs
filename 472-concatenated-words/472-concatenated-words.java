class Solution {
    Set<String> concatedWords = new HashSet<>();
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for(String w : words) wordSet.add(w);
        
        List<String> result = new ArrayList<>();
        
        for(String w : words) {
            if (helper(w, wordSet)) result.add(w);
        }
        
        return result;
    }
    
    boolean helper(String str, Set<String> wordSet) {
        if (concatedWords.contains(str)) return true;
        
        for(int i = 1; i < str.length(); i++) {
            String prefix = str.substring(0, i);
            String left = str.substring(i);
            
            if (wordSet.contains(prefix) && (wordSet.contains(left) || helper(left, wordSet))) {
                concatedWords.add(str);
                break;
            }
        }
        
        return concatedWords.contains(str);
    }
}