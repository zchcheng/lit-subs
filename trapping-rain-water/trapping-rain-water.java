class Solution {
    public int trap(int[] height) {
        Deque<int[]> stack = new LinkedList<>();
        
        int result = 0;
        
        for(int i = 0; i < height.length; i++) {
            int h = height[i];
            
            while(!stack.isEmpty() && stack.peek()[1] < h) {
                int[] prev = stack.pop();
                
                if (stack.isEmpty()) continue;
                
                int rh = Math.min(h, stack.peek()[1]) - prev[1];
                int w = i - stack.peek()[0] - 1;
                
                result += Math.max(0, rh * w);
            }
            
            stack.push(new int[] {i, h});
        }
        
        return result;
    }
}