class Solution {
    public int[] findOrder(int nc, int[][] pre) {
        int[] idg = new int[nc];
        Map<Integer, List<Integer>> req = new HashMap<>();
        
        for(int[] p : pre) {
            List<Integer> s = req.computeIfAbsent(p[1], i -> new LinkedList<>());
            s.add(p[0]);
            idg[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < nc; i++) {
            if (idg[i] != 0) continue;
            q.offer(i);
        }
        
        int[] res = new int[nc];
        int idx = 0;
        
        while(!q.isEmpty()) {
            Integer i = q.poll();
            res[idx++] = i;
            List<Integer> s = req.get(i);
            
            if (s == null) continue;
            
            for(Integer si : s) {
                if (--idg[si] == 0) q.offer(si);
            }
        }
        
        if (idx != nc) return new int[0];
        
        return res;
    }
}