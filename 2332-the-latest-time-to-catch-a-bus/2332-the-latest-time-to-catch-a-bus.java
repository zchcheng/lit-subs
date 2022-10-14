class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int pi = 0;
        int result = 0;
        
        int pb = 0;
        for(int b : buses) {
            int cnt = 0;
            
            Stack<Integer> stack = new Stack();
            
            for(; cnt < capacity && pi < passengers.length && passengers[pi] <= b; cnt++, pi++) {
                stack.push(passengers[pi]);
            }
            
            int tmp = (stack.size() == capacity)? stack.peek() : b;
            
            int npb = pb;
            while(!stack.isEmpty() && stack.peek() == tmp) {
                npb = Math.max(npb, stack.peek());
                tmp = stack.pop() - 1;
            }
            
            if (tmp > pb) result = tmp;
            pb = npb;
        }
        
        return result;
    }
}