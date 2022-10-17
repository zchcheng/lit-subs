class MinStack {
    Stack<int[]> stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        int m = (stack.isEmpty())? val : Math.min(val, stack.peek()[0]);
        stack.push(new int[] {m, val});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[1];
    }
    
    public int getMin() {
        return stack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */