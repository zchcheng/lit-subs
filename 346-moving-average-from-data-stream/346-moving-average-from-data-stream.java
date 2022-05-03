class MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    int sum = 0;
    int size = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        sum += val;
        queue.offer(val);
        
        while (queue.size() > size) {
            sum -= queue.poll();
        }
        
        return sum / (double)queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */