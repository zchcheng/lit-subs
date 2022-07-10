class FreqStack {
    Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
    Map<Integer, Stack<Integer>> group = new HashMap<Integer, Stack<Integer>>();
    int maxFreq = 0;
    
    public FreqStack() {
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        
        Stack<Integer> stack = group.getOrDefault(f, new Stack<>());
        stack.push(val);
        group.put(f, stack);
    }
    
    public int pop() {
        Stack<Integer> stack = group.get(maxFreq);
        int res = stack.pop();
        freq.put(res, freq.get(res) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */