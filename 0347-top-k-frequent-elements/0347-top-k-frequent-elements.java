class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for(int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        
        for(Map.Entry<Integer, Integer> kv : cnt.entrySet()) {
            pq.offer(new int[] {kv.getValue(), kv.getKey()});
            if (pq.size() > k) pq.poll();
        }
        
        int[] res = new int[k];
        
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }
        
        return res;
    }
}