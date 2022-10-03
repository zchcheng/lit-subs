class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        
        words.remove(beginWord);
        
        Map<String, Set<String>> dag = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean found = false;
        
        while(!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> toRemove = new HashSet<>();
            
            for(int i = 0; i < size; i++) {
                String s = queue.poll();
                
                if (s.equals(endWord)) {
                    found = true;
                    break;
                }
                
                Set<String> vars = getVariants(s, words);
                
                for(String var : vars) dag.computeIfAbsent(var, k -> new HashSet<>()).add(s);
                
                toRemove.addAll(vars);
            }
            
            if (!found) {
                for(String s : toRemove) {
                    words.remove(s);
                    queue.offer(s);
                }
            }
        }
        
        if (!found) return List.of();
        
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        current.add(endWord);
        
        backtracking(beginWord, current, dag, result);
        
        return result;
    }
    
    void backtracking(String end, List<String> current, Map<String, Set<String>> dag, List<List<String>> result) {
        String last = current.get(current.size() - 1);
        
        if (last.equals(end)) {
            List<String> tmp = new ArrayList<>(current);
            Collections.reverse(tmp);
            result.add(tmp);
            return;
        }
        
        Set<String> neighbors = dag.getOrDefault(last, Set.of());
        
        for(String n : neighbors) {
            current.add(n);
            
            backtracking(end, current, dag, result);
            
            current.remove(current.size() - 1);
        }
    }
    
    Set<String> getVariants(String word, Set<String> wordList) {
        Set<String> result = new HashSet<>();
        
        char[] carr = word.toCharArray();
        
        for(int i = 0; i < carr.length; i++) {
            char c = carr[i];
            
            for(int j = 0; j < 26; j++) {
                carr[i] = (char)('a' + j);
                String ns = String.valueOf(carr);
                if (word.equals(ns)) continue;
                if (wordList.contains(ns)) result.add(ns);
            }
            
            carr[i] = c;
        }
        
        return result;
    }
}