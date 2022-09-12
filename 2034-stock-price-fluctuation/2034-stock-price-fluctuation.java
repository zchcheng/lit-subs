class StockPrice {
    int latestTimestamp = -1;
    int latestPrice = -1;
    
    Map<Integer, Integer> map = new HashMap<>();
    
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        
        maxHeap.offer(new int[] { price, timestamp });
        minHeap.offer(new int[] { price, timestamp });
        
        if (latestTimestamp <= timestamp) {
            latestPrice = price;
            latestTimestamp = timestamp;
        }
    }
    
    public int current() {
        return latestPrice;
    }
    
    public int maximum() {
        while (!maxHeap.isEmpty()) {
            int[] p = maxHeap.peek();
            if (map.get(p[1]) != p[0]) maxHeap.poll();
            else return p[0];
        }
        
        return -1;
    }
    
    public int minimum() {
        while (!minHeap.isEmpty()) {
            int[] p = minHeap.peek();
            if (map.get(p[1]) != p[0]) minHeap.poll();
            else return p[0];
        }
        
        return -1;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */