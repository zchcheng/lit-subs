class Solution {
    public int trap(int[] height) {
        int res = 0;
        
        Deque<int[]> stack = new LinkedList<>();
        
        for(int i = 0; i < height.length; i++) {
            int h = height[i];
            
            while(!stack.isEmpty() && stack.peek()[0] < h) {
                int[] prev = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(stack.peek()[0], h) - prev[0]) * (i - stack.peek()[1] - 1);
            }
            
            stack.push(new int[] {h, i});
        }
        
        return res;
    }
}