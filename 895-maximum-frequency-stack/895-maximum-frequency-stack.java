class FreqStack {
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>((a, b) -> {
        if (a.getValue()[0] == b.getValue()[0]) return b.getValue()[1] - a.getValue()[1];
        return b.getValue()[0] - a.getValue()[0];
    });
    int cnter = 0;

    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0);
        pq.offer(new Pair(val, new int[] {freq + 1, cnter++}));
        map.put(val, freq + 1);
    }
    
    public int pop() {
        Pair<Integer, int[]> p = pq.poll();
        map.put(p.getKey(), p.getValue()[0] - 1);
        return p.getKey();
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */