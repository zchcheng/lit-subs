class Solution {
    public int trap(int[] height) {
        Stack<int[]> stack = new Stack<>();
        
        int res = 0;
        
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < height[i]) {
                int[] p = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(stack.peek()[0], height[i]) - p[0]) * (i - stack.peek()[1] - 1);
            }
            
            stack.push(new int[] {height[i], i});
        }
        
        return res;
    }
}