class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        
        Stack<long[]> stack = new Stack<>();
        
        for(int i = 0; i <= nums.length; i++) {
            long v = (i == nums.length)? Long.MAX_VALUE : nums[i];
            while(!stack.isEmpty() && stack.peek()[0] <= v) {
                long[] p = stack.pop();
                long prev = (stack.isEmpty())? -1 : stack.peek()[1];
                res += p[0] * ((p[1] - prev) * (i - p[1]));
            }
            stack.push(new long[] {v, i});
        }
        
        stack = new Stack<>();
        
        for(int i = 0; i <= nums.length; i++) {
            long v = (i == nums.length)? Long.MIN_VALUE : nums[i];
            while(!stack.isEmpty() && stack.peek()[0] >= v) {
                long[] p = stack.pop();
                long prev = (stack.isEmpty())? -1 : stack.peek()[1];
                res -= p[0] * ((p[1] - prev) * (i - p[1]));
            }
            stack.push(new long[] {v, i});
        }
        
        return res;
    }
}