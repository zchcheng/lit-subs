class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        
        for(int a : asteroids) {
            if (a > 0) {
                stack.push(a);
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                stack.pop();
            }
            
            if (stack.isEmpty() || stack.peek() < 0) stack.push(a); 
            else if (!stack.isEmpty() && stack.peek() == -a) stack.pop();
        }
        
        
        int[] res = new int[stack.size()];
        int idx = 0;
        
        while(!stack.isEmpty()) {
            res[idx++] = stack.pollLast();
        }
        
        return res;
    }
}