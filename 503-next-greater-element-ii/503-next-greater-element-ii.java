class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        
        Arrays.fill(result, -1);
        
        Deque<int[]> stack = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            
            while (!stack.isEmpty() && stack.peek()[0] < n) {
                int[] p = stack.pop();
                result[p[1]] = n;
            }
            
            stack.push(new int[] {n, i});
        }
        
        if (stack.size() > 1) {
            int[] greatest = stack.pollLast();
            
            for(int i = 0; i <= greatest[1]; i++) {
                int n = nums[i];
                while (!stack.isEmpty() && stack.peek()[0] < n) {
                    int[] p = stack.pop();
                    result[p[1]] = n;
                }
            }
        }
        
        return result;
    }
}