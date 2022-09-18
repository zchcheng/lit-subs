class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> dag = bfs(beginWord, endWord, new HashSet<>(wordList));
        
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> current = new LinkedList<>();
        current.add(endWord);
        
        dfs(dag, beginWord, current, result);
        
        return result;
    }
    
    Map<String, Set<String>> bfs(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Set<String>> result = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Set<String> added = new HashSet<>();
            
            for(int i = 0; i < size; i++) {
                String w = queue.poll();
                
                if (w.equals(endWord)) return result;
                
                for(String n : findNeighbors(w, wordList)) {
                    result.computeIfAbsent(n, k -> new HashSet<>()).add(w);
                    added.add(n);
                }
            }
            
            for(String w : added) {
                if (w.equals(endWord)) return result;
                queue.offer(w);
                wordList.remove(w);
            }
        }
        
        return result;
    }
    
    Set<String> findNeighbors(String word, Set<String> wordList) {
        Set<String> result = new HashSet<>();
        
        char[] charArr = word.toCharArray();
        
        for(int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            for(int j = 0; j < 26; j++) {
                char nc = (char)('a' + j);
                if (c == nc) continue;
                
                charArr[i] = nc;
                
                String ns = new String(charArr);
                if (wordList.contains(ns)) result.add(ns);
            }
            charArr[i] = c;
        }
        
        return result;
    }
    
    void dfs(Map<String, Set<String>> dag, String endWord, LinkedList<String> current, List<List<String>> result) {
        String currentWord = current.peekLast();
        
        if (currentWord.equals(endWord)) {
            List<String> path = new LinkedList<>(current);
            Collections.reverse(path);
            result.add(path);
            return;
        }
        
        for(String w : dag.getOrDefault(currentWord, new HashSet<>())) {
            current.add(w);
            
            dfs(dag, endWord, current, result);
            
            current.removeLast();
        }
    }
}