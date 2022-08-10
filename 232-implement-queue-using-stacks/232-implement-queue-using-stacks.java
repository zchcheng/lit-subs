class MyQueue {
    Stack<Integer> stk = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        reverse();
        int result = stk.pop();
        reverse();
        return result;
    }
    
    public int peek() {
        reverse();
        int result = stk.peek();
        reverse();
        return result;
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
    
    void reverse() {
        Stack<Integer> next = new Stack<>();
        
        while(!stk.isEmpty()) {
            next.push(stk.pop());
        }
        
        stk = next;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */