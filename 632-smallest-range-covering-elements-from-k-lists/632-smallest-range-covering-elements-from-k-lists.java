class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = null;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        
        int[] cur = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int i = 0; i < nums.size(); i++) {
            int n = nums.get(i).get(0);
            cur[0] = Math.min(cur[0], n);
            cur[1] = Math.max(cur[1], n);
            pq.offer(new int[] {n, i, 0});
        }
        
        res = new int[] {cur[0], cur[1]};
        
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            
            cur[0] = Math.max(cur[0], p[0]);
            
            if (cur[1] - cur[0] < res[1] - res[0]) {
                res[0] = cur[0];
                res[1] = cur[1];
            }
            
            if (nums.get(p[1]).size() - 1 == p[2]) {
                return res;
            }
            
            int n = nums.get(p[1]).get(p[2] + 1);
            
            cur[1] = Math.max(cur[1], n);
            
            pq.offer(new int[] {n, p[1], p[2] + 1});
        }
        
        return res;
    }
}