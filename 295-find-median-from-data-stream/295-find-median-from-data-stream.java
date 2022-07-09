class MedianFinder {
    PriorityQueue<Integer> minq = new PriorityQueue<>((a, b) -> a - b);
    PriorityQueue<Integer> maxq = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (minq.isEmpty() || num > minq.peek()) minq.offer(num); 
        else maxq.offer(num);
        
        while (minq.size() >= maxq.size() + 2) maxq.offer(minq.poll()); 
        
        while(maxq.size() >= minq.size() + 2) minq.offer(maxq.poll());
    }
    
    public double findMedian() {
        int total = minq.size() + maxq.size();
        
        if (total % 2 == 0) {
            return (maxq.peek() + minq.peek()) / 2.0;
        } else {
            return (maxq.size() > minq.size())? maxq.peek() : minq.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */