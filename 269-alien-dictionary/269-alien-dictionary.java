class Solution {
    Map<Character, Set<Character>> map = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();
    
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        
        addWord(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            int didx = diff(words[i], words[i - 1]);
            
            addWord(words[i]);
            
            if (didx == -1) {
                if (words[i - 1].length() > words[i].length() && words[i - 1].startsWith(words[i])) return "";
                continue;
            }
            
            Set<Character> pointing = map.computeIfAbsent(words[i - 1].charAt(didx), k -> new HashSet<>());
            
            if (pointing.contains(words[i].charAt(didx))) continue;
            
            pointing.add(words[i].charAt(didx));
            indegree.put(words[i].charAt(didx), indegree.getOrDefault(words[i].charAt(didx), 0) + 1);
        }
        
        return topoSort();
    }
    
    void addWord(String s) {
        for(char c : s.toCharArray()) indegree.computeIfAbsent(c, k -> 0);
    }
    
    String topoSort() {
        String res = "";
        
        Queue<Character> queue = new LinkedList<>();
        
        for(Map.Entry<Character, Integer> kv : indegree.entrySet()) {
            if (kv.getValue() == 0) queue.offer(kv.getKey());
        }
        
        while(!queue.isEmpty()) {
            char c = queue.poll();
            res += c;
            
            Set<Character> s = map.getOrDefault(c, new HashSet<>());
            
            for(char r : s) {
                indegree.put(r, indegree.getOrDefault(r, 0) - 1);
                if (indegree.get(r) <= 0) queue.offer(r);
            }
        }
        
        for(Map.Entry<Character, Integer> kv : indegree.entrySet()) {
            if (kv.getValue() > 0) return "";
        }
        
        return res;
    }
    
    int diff(String a, String b) {
        int sza = a.length();
        int szb = b.length();
        
        int i = 0;
        for(; i < Math.min(sza, szb); i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        
        return -1;
    }
}