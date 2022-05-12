class Solution {
    Set<String> visited = new HashSet<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }
    
    boolean helper(String s, List<String> wd) {
        if (s.isEmpty()) {
            return true;
        }
        
        if (visited.contains(s)) return false;
        
        visited.add(s);
        
        for(String w : wd) {
            if (s.startsWith(w) && helper(s.substring(w.length()), wd)) {
                return true;
            }
        }
        
        return false;
    }
}