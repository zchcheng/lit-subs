class Solution {
    public int[] findOrder(int nc, int[][] pre) {
        
        Map<Integer, Integer> dep = new HashMap<>();
        Map<Integer, Set<Integer>> req = new HashMap<>();
        
        for(int[] p : pre) {
            Set<Integer> s = req.computeIfAbsent(p[1], i -> new HashSet<>());
            s.add(p[0]);
            dep.put(p[0], dep.getOrDefault(p[0], 0) + 1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nc; i++) {
            if (dep.containsKey(i)) continue;
            q.offer(i);
        }
        
        while(!q.isEmpty()) {
            Integer i = q.poll();
            res.add(i);
            Set<Integer> s = req.get(i);
            if (s == null) continue;
            for(Integer si : s) {
                Integer cnt = dep.get(si);
                if (cnt != 1) {
                    dep.put(si, cnt - 1);
                    continue;
                }
                dep.remove(si);
                q.offer(si);
            }
        }
        
        if (!dep.isEmpty()) return new int[0];
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}