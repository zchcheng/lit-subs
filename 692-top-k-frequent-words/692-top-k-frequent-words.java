class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String w : words) { map.put(w, map.getOrDefault(w, 0) + 1); }
        
        List<Count> list = map.entrySet().stream().map(kv -> new Count(kv.getKey(), kv.getValue())).collect(Collectors.toList());
        
        PriorityQueue<Count> pq = new PriorityQueue<>((Count a, Count b) -> {
            if (a.count == b.count) {
                return b.word.compareTo(a.word);
            }
            return a.count - b.count;
        });
        
        for(Count c : list) {
            pq.offer(c);
            while(pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> res = new LinkedList<>();
        
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().word);
        }
        
        return res;
    }
    
    class Count {
        public String word;
        public int count;
        public Count(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}