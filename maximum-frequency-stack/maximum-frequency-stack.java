class FreqStack {
    int curMaxFreq = 0;
    Map<Integer, Integer> numOfEl = new HashMap<>();
    Map<Integer, Stack<Integer>> stacks = new HashMap<>();
    
    public FreqStack() {
    }
    
    public void push(int val) {
        int freq = numOfEl.getOrDefault(val, 0) + 1;
        numOfEl.put(val, freq);
        curMaxFreq = Math.max(curMaxFreq, freq);
        Stack<Integer> stack = stacks.computeIfAbsent(freq, k -> new Stack<>());
        stack.push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = stacks.get(curMaxFreq);
        int result = stack.pop();
        if (stack.isEmpty()) curMaxFreq--;
        numOfEl.put(result, numOfEl.get(result) - 1);
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */