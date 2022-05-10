class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Map<Integer, Integer> cnt = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(Integer i : map.values()) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        
        for(Integer i : cnt.keySet()) {
            pq.offer(i);
        }
        
        int res = 0;
        
        while(!pq.isEmpty()) {
            int i = pq.poll();
            int c = cnt.getOrDefault(i, 0);
            if (c <= 1) continue;
            
            res += (c - 1);
            
            if (i == 1) { break; }
            
            if (!cnt.containsKey(i - 1)) {
                pq.offer(i - 1);
            }
            
            cnt.put(i - 1, cnt.getOrDefault(i - 1, 0) + c - 1);
        }
        
        return res;
    }
}