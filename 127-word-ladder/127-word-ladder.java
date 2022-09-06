class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        
        Map<String, Set<String>> edges = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            String a = wordList.get(i);
            
            for(int j = i + 1; j < n; j++) {
                String b = wordList.get(j);
                
                if (isLinked(a, b)) {
                    Set<String> la = edges.computeIfAbsent(a, k -> new HashSet<>());
                    Set<String> lb = edges.computeIfAbsent(b, k -> new HashSet<>());
                    la.add(b);
                    lb.add(a);
                }
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        int turn = 1;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++) {
                String s = queue.poll();
                
                if (s.equals(endWord)) return turn;
                
                Set<String> linked = edges.getOrDefault(s, new HashSet<>());
                
                for(String l : linked) {
                    if (visited.contains(l)) continue;
                    queue.offer(l);
                    visited.add(l);
                }
            }
            
            turn++;
        }
        
        return 0;
    }
    
    boolean isLinked(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length() && diff <= 1; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff <= 1;
    }
}