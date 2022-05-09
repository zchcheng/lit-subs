class HitCounter {
    Queue<Integer> queue = new LinkedList<>();

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        autoPoll(timestamp);
        return queue.size();
    }
    
    void autoPoll(int time) {
        int d = time - 300;
        while(!queue.isEmpty() && queue.peek() <= d) {
            queue.poll();
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */