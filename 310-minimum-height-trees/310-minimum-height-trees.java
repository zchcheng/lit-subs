class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        if (n == 2) return List.of(0, 1);
            
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) 
            if (map.getOrDefault(i, new HashSet<>()).size() == 1) queue.offer(i);
        
        while(!queue.isEmpty() && map.size() > 2) {
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++) {
                int node = queue.poll();
                Set<Integer> s = map.get(node);
                map.remove(node);
                for(int c : s) {
                    Set<Integer> cs = map.getOrDefault(c, new HashSet<>());
                    cs.remove(node);
                    if (cs.size() == 1) queue.offer(c);
                }
            }
        }
        
        return new ArrayList<>(map.keySet());
    }
}