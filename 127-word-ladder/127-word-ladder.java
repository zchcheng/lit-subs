class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        
        Map<String, Set<String>> edges = new HashMap<>();
        
        for(int i = 0; i < wordList.size() - 1; i++) {
            String a = wordList.get(i);
            
            for(int j = i + 1; j < wordList.size(); j++) {
                String b = wordList.get(j);
                
                if (connected(a, b)) {
                    Set<String> s1 = edges.computeIfAbsent(a, k -> new HashSet<>());
                    Set<String> s2 = edges.computeIfAbsent(b, k -> new HashSet<>());
                    s1.add(b);
                    s2.add(a);
                }
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        visited.add(beginWord);
        
        for(int i = 0; i < wordList.size(); i++) {
            String w = wordList.get(i);
            if (visited.contains(w)) continue;
            if (connected(beginWord, w)) {
                queue.offer(w);
                visited.add(w);
            }
        }
        
        int len = 2;
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++) {
                String w = queue.poll();
                if (w.equals(endWord)) return len;
                
                for(String connect : edges.getOrDefault(w, new HashSet<>())) {
                    if (visited.contains(connect)) continue;
                    queue.offer(connect);
                    visited.add(connect);
                }
            }
            
            len++;
        }
            
        return 0;
    }
    
    boolean connected(String a, String b) {
        boolean flag = false;
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (flag) return false;
                flag = true;
            }
        }
        return true;
    }
}